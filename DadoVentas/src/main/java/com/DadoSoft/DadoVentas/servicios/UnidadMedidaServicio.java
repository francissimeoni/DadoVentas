package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.UnidadMedida;
import com.DadoSoft.DadoVentas.repositorio.UnidadMedidaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnidadMedidaServicio {

    @Autowired
    UnidadMedidaRepository umR;

    @Transactional
    public Boolean crearUnidadDeMedida(String Nombre) {

        try {

            UnidadMedida um = new UnidadMedida();

            um.setNombre(Nombre);
            um.setValorNominal(1);

            umR.save(um);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<UnidadMedida> traerUnidadesDeMedida() {

        return umR.findAll();

    }

}
