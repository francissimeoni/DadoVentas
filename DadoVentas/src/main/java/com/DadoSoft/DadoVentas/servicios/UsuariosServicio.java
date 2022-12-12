package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.GerarquiaUsuario;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.enums.Rol;
import com.DadoSoft.DadoVentas.repositorio.UsuariosRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicio {

    @Autowired
    UsuariosRepository uR;

    @Transactional
    public void CrearUsuario(String Usuario, String Contraseña,
            String Domicilio, String Telefono, String Email, Boolean ComisionSiNo, Boolean ActivoSiNo,
            GerarquiaUsuario GerarquiaUsuario, Rol Rol) throws Exception {
        Usuarios usuarioTemporal = new Usuarios();

        validaciones(Usuario, Contraseña, GerarquiaUsuario);

        usuarioTemporal.setActivoSiNo(ActivoSiNo);
        usuarioTemporal.setComisionSiNo(ComisionSiNo);
        usuarioTemporal.setContraseña(Contraseña);
        usuarioTemporal.setDomicilio(Domicilio);
        usuarioTemporal.setEmail(Email);
        usuarioTemporal.setGerarquiaUsuario(GerarquiaUsuario);
        usuarioTemporal.setRol(Rol);
        usuarioTemporal.setTelefono(Telefono);
        usuarioTemporal.setUsuario(Usuario);

        uR.save(usuarioTemporal);

    }

    public void validaciones(String Usuario, String Contraseña,
            GerarquiaUsuario GerarquiaUsuario) throws Exception {

        if (Usuario.equalsIgnoreCase("")) {
            throw new MiExcepcion("El campo USUARIO no puede estar vacio");
        }

        if (Contraseña.equalsIgnoreCase("")) {
            throw new MiExcepcion("El campo CONSTRASEÑA no puede estar vacio");

        }
        if ("".equalsIgnoreCase(GerarquiaUsuario.getGerarquiaUsuario())) {
            throw new MiExcepcion("Tenés ques Seleccionar un valor en el campo de GERARQUIA USUARIO");

        }

    }

}
