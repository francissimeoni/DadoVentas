package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Clientes;
import com.DadoSoft.DadoVentas.Entidades.Comprobantes;
import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.ProductosExtendido;
import com.DadoSoft.DadoVentas.Entidades.Proveedores;
import com.DadoSoft.DadoVentas.Entidades.Sucursal;
import com.DadoSoft.DadoVentas.Entidades.TipoComprobante;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import com.DadoSoft.DadoVentas.repositorio.ComprobantesRepository;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprobantesServicio {

    @Autowired
    ComprobantesRepository cR;

    public Boolean crearNuevoComprobante(int tipoComprobante, int ticket, Clientes cliente, Usuarios usuario,
            double monto, double iva, String lista, String anotacion, double descuento,
            ArrayList<ProductosExtendido> productos, Date fecha, Sucursal sucursal, Proveedores proveedor) {

        Comprobantes c = new Comprobantes();
        /*tipo comprobante 1 = Factura, 2= Recibo, 3= remito, 4= nota de credito, 5= nota de debito, 6 = presupuesto
        7 = nota de pedido, 8 = nota de venta      
         */
        TipoComprobante tc = new TipoComprobante();
        TipoComprobanteServicio tcS = new TipoComprobanteServicio();
        ConfiguracionServicio cS = new ConfiguracionServicio();
        int numeroDeTicket = 0;

        try {

            switch (tipoComprobante) {

                case 1:
                    tc = tcS.ObtenerTipoDeComprobante("factura");
                    numeroDeTicket = cS.obtenerUltimoTicket(1) + 1;
                    break;
                case 2:
                    tc = tcS.ObtenerTipoDeComprobante("recibo");
                    numeroDeTicket = cS.obtenerUltimoTicket(2) + 1;
                    break;
                case 3:
                    tc = tcS.ObtenerTipoDeComprobante("remito");
                    numeroDeTicket = cS.obtenerUltimoTicket(3) + 1;
                    break;
                case 4:
                    tc = tcS.ObtenerTipoDeComprobante("notaDeCredito");
                    numeroDeTicket = cS.obtenerUltimoTicket(4) + 1;
                    break;
                case 5:
                    tc = tcS.ObtenerTipoDeComprobante("notaDeDebito");
                    numeroDeTicket = cS.obtenerUltimoTicket(5) + 1;
                    break;
                case 6:
                    tc = tcS.ObtenerTipoDeComprobante("presupuesto");
                    numeroDeTicket = cS.obtenerUltimoTicket(6) + 1;
                    break;
                case 7:
                    tc = tcS.ObtenerTipoDeComprobante("notaDePedido");
                    numeroDeTicket = cS.obtenerUltimoTicket(7) + 1;
                    break;
                case 8:
                    tc = tcS.ObtenerTipoDeComprobante("notaDeVenta");
                    numeroDeTicket = cS.obtenerUltimoTicket(8) + 1;
                    break;

            }

            c.setAnotacion(anotacion);
            c.setCliente(cliente);
            c.setDescuento(descuento);
            c.setFecha(fecha);
            c.setIva(iva);
            c.setLista(lista);
            c.setMonto(monto);
            c.setNumeroComprobante(tipoComprobante);
            c.setProductos(productos);
            c.setProveedor(proveedor);
            c.setSucursal(sucursal);
            c.setTipoDeComprobante(tc);
            c.setUsuario(usuario);
            c.setNumeroDeTicket(numeroDeTicket);

            cR.save(c);

            cS.actualizarNumeroDeTicket(tipoComprobante, numeroDeTicket);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
