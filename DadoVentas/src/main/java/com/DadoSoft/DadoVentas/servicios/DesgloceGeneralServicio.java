package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.DesgloceGeneral;
import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.repositorio.DesgloceGeneralRepository;
import jdk.nashorn.internal.ir.TryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesgloceGeneralServicio {

    @Autowired
    DesgloceGeneralRepository dgR;

    @Autowired
    ProductosServicio pS;

    public Boolean CrearNuevoItem(int ticket, int cantidad, Productos producto, float lista) {
        try {

            DesgloceGeneral nuevoItem = new DesgloceGeneral();

            nuevoItem.setCantidad(cantidad);
            nuevoItem.setComision(producto.getComision());
            nuevoItem.setComprobante(ticket);
            nuevoItem.setPrecio(pS.obtenerPrecioProductoPorId(producto.getIdProducto(), lista));
            nuevoItem.setProducto(producto);
            dgR.save(nuevoItem);
            
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
