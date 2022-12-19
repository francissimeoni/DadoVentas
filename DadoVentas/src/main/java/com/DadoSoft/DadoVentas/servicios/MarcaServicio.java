package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Marca;
import com.DadoSoft.DadoVentas.repositorio.MarcaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarcaServicio {

    @Autowired
    MarcaRepository mr;

    @Transactional
    public Boolean crearNuevaMarca(String nombre) {

        Marca m = new Marca();

        try {
            m.setMarca(nombre);
            mr.save(m);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    @Transactional
    public Boolean editarMarca(Long idMarca, String nombre) {

        Marca m = new Marca();
        Optional<Marca> op = mr.findById(idMarca);

        if (op.isPresent()) {
            m = op.get();
            m.setMarca(nombre);
            return true;
        } else {
            return false;
        }

    }

    public List<Marca> traerTodosLasMarcas() {

        return mr.findAll();

    }

}
