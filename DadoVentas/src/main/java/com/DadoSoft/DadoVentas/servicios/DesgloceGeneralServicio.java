package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.DesgloceGeneral;
import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.ProductosExtendido;
import com.DadoSoft.DadoVentas.repositorio.DesgloceGeneralRepository;
import java.util.ArrayList;
import jdk.nashorn.internal.ir.TryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesgloceGeneralServicio {

    @Autowired
    DesgloceGeneralRepository dgR;

    @Autowired
    ProductosServicio pS;

    public Boolean CrearNuevoItem(int ticket, ArrayList<ProductosExtendido> productos) {
        try {

            for (ProductosExtendido producto : productos) {

                DesgloceGeneral nuevoItem = new DesgloceGeneral();

                nuevoItem.setCantidad(producto.getCantidad());
                nuevoItem.setComision(producto.getComision());
                nuevoItem.setComprobante(ticket);
                nuevoItem.setPrecio(producto.getPrecio());
                nuevoItem.setProducto(producto);
                dgR.save(nuevoItem);

            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
