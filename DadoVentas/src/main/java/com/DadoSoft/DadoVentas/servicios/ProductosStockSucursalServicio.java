package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.ProductosStockSucursal;
import com.DadoSoft.DadoVentas.Entidades.Sucursal;
import com.DadoSoft.DadoVentas.repositorio.ProductosStockSucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductosStockSucursalServicio {

    @Autowired
    ProductosStockSucursalRepository pssR;

   /* public void IncrementarStockSucursal(Productos producto, int cantidad, Sucursal sucursal) {
        ProductosStockSucursal StockEnSucursal;
        StockEnSucursal = pssR.buscarProductoPorSucursal(producto.getIdProducto(), sucursal.getIdSucursal());

        //si no existe se carga un nuevo producto en la tabla, sino se incrementa el stock del mismo
        if (StockEnSucursal == null) {

            StockEnSucursal.setCantidad(cantidad);
            StockEnSucursal.setCantidadMinima(0);
            StockEnSucursal.setProducto(producto);
            StockEnSucursal.setSucursal(sucursal);

            pssR.save(StockEnSucursal);

        } else {

            int cantidadAnterior = StockEnSucursal.getCantidad();
            StockEnSucursal.setCantidad(cantidadAnterior + cantidad);
            pssR.save(StockEnSucursal);

        }

    }
*/
}
