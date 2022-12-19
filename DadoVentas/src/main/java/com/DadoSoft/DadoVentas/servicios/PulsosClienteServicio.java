package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Clientes;
import com.DadoSoft.DadoVentas.Entidades.PulsosCliente;
import com.DadoSoft.DadoVentas.Entidades.PulsosMotivosCliente;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import com.DadoSoft.DadoVentas.repositorio.ClientesRepository;
import com.DadoSoft.DadoVentas.repositorio.PulsosMotivosClienteRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PulsosClienteServicio {

    
    @Autowired
    PulsosMotivosClienteRepository pmcR;

    @Autowired
    ClientesRepository cR;

    @Transactional
    public Boolean nuevoPulso(Long idCliente, Long IdPulsoMotivoCliente, Usuarios usuario) {

        PulsosMotivosCliente motivoDelPulso = new PulsosMotivosCliente();
        Clientes cliente = new Clientes();

        Optional<PulsosMotivosCliente> opMotivo = pmcR.findById(IdPulsoMotivoCliente);
        Optional<Clientes> opCliente = cR.findById(idCliente);

        if (opMotivo.isPresent() && opCliente.isPresent()) {

            motivoDelPulso = opMotivo.get();
            cliente = opCliente.get();

            PulsosCliente nuevoPulso = new PulsosCliente();
            Date fecha = new Date();

            Integer año = fecha.getYear();
            Integer mes = fecha.getMonth();
            Integer dia = fecha.getDay() - 3;

            Date fechaEditada = new Date(año, mes, dia);

            nuevoPulso.setClientes(cliente);
            nuevoPulso.setPulsosmotivoscliente(motivoDelPulso);
            nuevoPulso.setFecha(fechaEditada);
            nuevoPulso.setUsuarios(usuario);
            return true;
        } else {
            return false;
        }

    }

}
