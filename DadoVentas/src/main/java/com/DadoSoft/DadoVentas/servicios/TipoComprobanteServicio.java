package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.TipoComprobante;
import com.DadoSoft.DadoVentas.repositorio.TipoComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoComprobanteServicio {

    @Autowired
    TipoComprobanteRepository tcR;

    public TipoComprobante ObtenerTipoDeComprobante(String nombre) {

        return tcR.buscarNombreComprobante(nombre);
        
    }

}
