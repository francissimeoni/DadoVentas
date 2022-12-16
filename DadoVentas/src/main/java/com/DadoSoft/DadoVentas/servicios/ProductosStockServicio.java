package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.ProductosStock;
import com.DadoSoft.DadoVentas.Entidades.Sucursal;
import com.DadoSoft.DadoVentas.repositorio.ProductosRepository;
import com.DadoSoft.DadoVentas.repositorio.ProductosStockRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosStockServicio {

    @Autowired
    ProductosStockRepository psR;

    @Autowired
    ProductosStockSucursalServicio pssS;

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

    public Boolean distribuirStock(Productos producto,Integer cantidad, Sucursal sucursal) {

        /*
        // 0 - idProducto - 1 Cantidad - 2 Sucursal
        for (Integer arrayStock : StockaMover) {
            Integer l = arrayStock[0];
            Productos p = pR.findById();

        }*/

        return true;
    }
}
