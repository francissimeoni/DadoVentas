package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.GerarquiaUsuario;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.repositorio.GerarquiaUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

@Service
public class GerarquiaUsuarioServicio {

    @Autowired
    GerarquiaUsuarioRepository GuR;

    @Transactional
    public void crearGerarquia() {
        GerarquiaUsuario Gu = new GerarquiaUsuario();
        Gu.setGerarquiaUsuario("Repartidor");
        GuR.save(Gu);

    }

    public GerarquiaUsuario obtenerGerarquiaPorId(Long id) throws MiExcepcion {

        Optional<GerarquiaUsuario> gU = GuR.findById(id);

        if (gU.isPresent()) {

            return (gU.get());

        } else {

            throw new MiExcepcion("No existen gerarquias con esa id");

        }

    }

}
