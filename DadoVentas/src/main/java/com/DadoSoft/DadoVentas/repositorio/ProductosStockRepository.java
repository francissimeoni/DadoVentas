
package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.ProductosStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface ProductosStockRepository extends JpaRepository<ProductosStock, Long> {
    
}
