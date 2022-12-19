package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Modelo;
import com.DadoSoft.DadoVentas.Entidades.PulsosMotivosCliente;
import com.DadoSoft.DadoVentas.repositorio.PulsosMotivosClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PulsosMotivosClienteServicio {
    
    @Autowired
    PulsosMotivosClienteRepository pmcR;
    
    @Transactional
    public Boolean crearNuevoMotivo(String mensaje, Integer valor) {
        
        PulsosMotivosCliente motivo = new PulsosMotivosCliente();
        
        try {
            motivo.setMensaje(mensaje);
            motivo.setValor(valor);
            motivo.setActivoSiNo(true);
            pmcR.save(motivo);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    @Transactional
    public Boolean editarMotivo(Long idMotivo, String mensaje, Integer valor) {
        
        PulsosMotivosCliente m = new PulsosMotivosCliente();
        Optional<PulsosMotivosCliente> op = pmcR.findById(idMotivo);
        
        if (op.isPresent()) {
            m = op.get();
            m.setMensaje(mensaje);
            m.setValor(valor);
            pmcR.save(m);
            return true;
        } else {
            return false;
        }
        
    }
    
    public List<PulsosMotivosCliente> traerTodosLosMotivos() {
        
        return pmcR.findAll();
        
    }
    
    @Transactional
    public Boolean ActivarDesactivarPulso(Long idMotivo, Boolean estadoAsignado) {
        
        PulsosMotivosCliente m = new PulsosMotivosCliente();
        Optional<PulsosMotivosCliente> op = pmcR.findById(idMotivo);
        
        if (op.isPresent()) {
            m = op.get();
            m.setActivoSiNo(estadoAsignado);
            pmcR.save(m);
            return true;
        } else {
            return false;
        }
        
    }
}
