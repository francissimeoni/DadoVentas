package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Modelo;
import com.DadoSoft.DadoVentas.repositorio.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloServicio {

    @Autowired
    ModeloRepository mR;

    public boolean cargarModelo(Modelo modelo) {
        return true;
    }

}
