package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Modelo;
import com.DadoSoft.DadoVentas.repositorio.ModeloRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloServicio {

    @Autowired
    ModeloRepository mR;

    @Transactional
    public Boolean crearNuevoModelo(String nombre) {

        Modelo m = new Modelo();

        try {
            m.setModelo(nombre);
            mR.save(m);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Transactional
    public Boolean editarModelo(Long idModelo, String nombre) {

        Modelo m = new Modelo();
        Optional<Modelo> op = mR.findById(idModelo);

        if (op.isPresent()) {
            m = op.get();
            m.setModelo(nombre);
            return true;
        } else {
            return false;
        }

    }

    public List<Modelo> traerTodosLosModelos() {

        return mR.findAll();

    }
}
