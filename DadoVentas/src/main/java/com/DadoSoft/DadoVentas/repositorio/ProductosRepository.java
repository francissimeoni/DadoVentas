
package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Integer>{
    
}
