package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.ProductosStock;
import com.DadoSoft.DadoVentas.repositorio.ProductosRepository;
import com.DadoSoft.DadoVentas.repositorio.ProductosStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosStockServicio {

    @Autowired
    ProductosStockRepository psR;

    @Autowired
    ProductosRepository pR;

    public void CargarStock(Integer cantidad) {
        Productos p = pR.ObtenerUltimoProducto();
        ProductosStock ps = new ProductosStock();
        ps.setIdProducto(p.getIdProducto());
        ps.setCantidad(cantidad);
        psR.save(ps);
    }

    public void SumarStock() {

    }

    public void RestarStock() {

    }

}
