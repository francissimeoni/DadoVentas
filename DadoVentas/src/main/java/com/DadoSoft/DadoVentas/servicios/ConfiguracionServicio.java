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

    public Boolean CrearConfiguracion(String IIBB, CondicionIva condicionIva, String inicioDeActividad, Imagenes imagen, String cai, String nombreDeFantasía,
            String productKey, String direccion, String localidad, String provincia, String cp, String correoElectronico, String telefonoMovil1, String telefonoMovil2,
            String telefonoMovil3, String telefonoMovil4, String telefonoFijo1, String telefonoFijo2, String telefonoFijo3, String telefonoFijo4, String redSocial1, String redSocial2,
            String redSocial3, String redSocial4, Integer ticketVenta, Integer ticketRemito, Integer ticketPresupuesto, Integer ticketNotaDeCredito, Integer ticketNotaDeDebito,
            Integer ticketNotaDePedido, Integer ticketNotaDeVenta, Integer ticketRecibo) {

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
        c.setTicketRecibo(ticketRecibo);

        cR.save(c);

        return true;
    }

    public int nuevoTicketDeVenta() {

        Configuracion c = cR.TraerDatosDeConfiguracion();

        return c.getTicketVenta() + 1;

    }

    public int obtenerUltimoTicket(int tipoComprobante) {
        Configuracion c = new Configuracion();

        switch (tipoComprobante) {

            case 1:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketVenta();

            case 2:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketRecibo();

            case 3:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketRemito();

            case 4:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketNotaDeCredito();

            case 5:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketNotaDeDebito();

            case 6:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketPresupuesto();

            case 7:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketNotaDePedido();

            case 8:
                c = cR.TraerDatosDeConfiguracion();
                return c.getTicketNotaDeVenta();

        }

        return 0;
    }

    public void actualizarNumeroDeTicket(int tipoComprobante, int nuevoNumero) {
        Configuracion c = new Configuracion();

        switch (tipoComprobante) {

            case 1:
                c = cR.TraerDatosDeConfiguracion();
                c.setTicketVenta(nuevoNumero);
                cR.save(c);
                break;

            case 2:
                c = cR.TraerDatosDeConfiguracion();
                c.setTicketRecibo(nuevoNumero);
                cR.save(c);
            case 3:
                 c = cR.TraerDatosDeConfiguracion();
                c.setTicketRemito(nuevoNumero);
                cR.save(c);

            case 4:
                c = cR.TraerDatosDeConfiguracion();
                c.setTicketNotaDeCredito(nuevoNumero);
                cR.save(c);

            case 5:
                 c = cR.TraerDatosDeConfiguracion();
                c.setTicketNotaDeDebito(nuevoNumero);
                cR.save(c);
            case 6:
              c = cR.TraerDatosDeConfiguracion();
                c.setTicketPresupuesto(nuevoNumero);
                cR.save(c);
            case 7:
                c = cR.TraerDatosDeConfiguracion();
                c.setTicketNotaDePedido(nuevoNumero);
                cR.save(c);
            case 8:
                c = cR.TraerDatosDeConfiguracion();
                c.setTicketNotaDeVenta(nuevoNumero);
                cR.save(c);
        }
    }

}
