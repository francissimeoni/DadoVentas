package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Rubro;
import com.DadoSoft.DadoVentas.repositorio.RubroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RubroServicio {

    @Autowired
    RubroRepository rR;

    @Transactional
    public Boolean crearNuevoRubro(String nombre) {

        Rubro r = new Rubro();

        try {

            r.setRubro(nombre);
            rR.save(r);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    @Transactional
    public Boolean editarRubro(Long idRubro, String nombre) {

        Rubro r = new Rubro();
        Optional<Rubro> op = rR.findById(idRubro);

        if (op.isPresent()) {
            r = op.get();
            r.setRubro(nombre);
            return true;
        } else {
            return false;
        }

    }

    public List<Rubro> traerTodosLosRubros() {

        return rR.findAll();

    }

}
