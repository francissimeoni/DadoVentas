package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.CondicionIva;
import com.DadoSoft.DadoVentas.Entidades.Configuracion;
import com.DadoSoft.DadoVentas.Entidades.Imagenes;
import com.DadoSoft.DadoVentas.repositorio.ConfiguracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ConfiguracionServicio {

    @Autowired
    ConfiguracionRepository cR;

    @Transactional

    public Boolean CrearConfiguracion(String IIBB, CondicionIva condicionIva, String inicioDeActividad, Imagenes imagen,  String cai, String nombreDeFantasía,
            String productKey, String direccion, String localidad, String provincia, String cp, String correoElectronico, String telefonoMovil1, String telefonoMovil2,
            String telefonoMovil3, String telefonoMovil4, String telefonoFijo1, String telefonoFijo2, String telefonoFijo3, String telefonoFijo4, String redSocial1, String redSocial2,
            String redSocial3, String redSocial4, Integer ticketVenta, Integer ticketRemito, Integer ticketPresupuesto, Integer ticketNotaDeCredito, Integer ticketNotaDeDebito,
            Integer ticketNotaDePedido, Integer ticketNotaDeVenta) {

        Configuracion c = new Configuracion();

        c.setCai(cai);
        c.setCondicionIva(condicionIva);
        c.setCorreoElectronico(correoElectronico);
        c.setCp(cp);
        c.setDireccion(direccion);
        c.setIIBB(IIBB);
        c.setImagen(imagen);
        c.setInicioDeActividad(inicioDeActividad);
        c.setLocalidad(localidad);
        c.setNombreDeFantasía(nombreDeFantasía);
        c.setNombreEmpresa(nombreDeFantasía);
        c.setPais(cai);
        c.setProductKey(productKey);
        c.setProvincia(provincia);
        c.setRedSocial1(redSocial1);
        c.setRedSocial2(redSocial2);
        c.setRedSocial3(redSocial3);
        c.setRedSocial4(redSocial4);
        c.setTelefonoFijo1(telefonoFijo1);
        c.setTelefonoFijo2(telefonoFijo2);
        c.setTelefonoFijo3(telefonoFijo3);
        c.setTelefonoFijo4(telefonoFijo4);
        c.setTelefonoMovil1(telefonoMovil1);
        c.setTelefonoMovil2(telefonoMovil2);
        c.setTelefonoMovil3(telefonoMovil3);
        c.setTelefonoMovil4(telefonoMovil4);
        c.setTicketNotaDeCredito(ticketNotaDeCredito);
        c.setTicketNotaDeDebito(ticketNotaDeDebito);
        c.setTicketNotaDePedido(ticketNotaDePedido);
        c.setTicketNotaDeVenta(ticketNotaDeVenta);
        c.setTicketPresupuesto(ticketPresupuesto);
        c.setTicketRemito(ticketRemito);
        c.setTicketVenta(ticketVenta);

        cR.save(c);

        return null;
    }

}
