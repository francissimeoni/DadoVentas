package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.GerarquiaUsuario;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.enums.Rol;
import com.DadoSoft.DadoVentas.repositorio.UsuariosRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuariosServicio implements UserDetailsService {

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
        usuarioTemporal.setContraseña(new BCryptPasswordEncoder().encode(Contraseña));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = uR.buscarPorEmailoUsuario(username);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);

            // una vez que ya se logueo, guardamos el usuario para utilizar sus datos
            // durante la sesion
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("SesionDeUsuario", usuario);

            User user = new User(usuario.getUsuario(), usuario.getContraseña(), permisos);
            return user;
        } else {
            return null;
        }

    }

}
