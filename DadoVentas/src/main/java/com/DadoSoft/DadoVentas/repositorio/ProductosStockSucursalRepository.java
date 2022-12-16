package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.ProductosStockSucursal;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosStockSucursalRepository extends JpaRepository<ProductosStockSucursal, Long> {

    @Query("select p from ProductosStockSucursal p where p.idProducto= :idProducto and p.idSucursal= :idSucursal")
    public ProductosStockSucursal buscarProductoPorSucursal(@Param("idProducto") Long idProducto, @Param("idSucursal") Long idSucursal);

}
