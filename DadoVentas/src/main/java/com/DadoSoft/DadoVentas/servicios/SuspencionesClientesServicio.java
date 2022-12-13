package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.SuspensionesClientes;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspencionesClientesServicio {

    @Autowired

    ClientesServicio cS;

    @Transactional
    public void suspenderCliente(Long idCliente, HttpSession session, String mensaje) {

        Usuarios logueado = (Usuarios) session.getAttribute("SesionDeUsuario");

        SuspensionesClientes sc = new SuspensionesClientes();
        sc.setIdCliente(idCliente);
        sc.setFecha(new Date());
        sc.setIdUsuario(logueado.getIdUsuario());
        sc.setMensaje(mensaje);
        cS.suspendeSino(idCliente, false);

    }

}
