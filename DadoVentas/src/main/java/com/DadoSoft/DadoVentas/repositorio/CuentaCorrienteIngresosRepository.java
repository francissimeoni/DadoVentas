
package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.CuentaCorrienteIngresos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaCorrienteIngresosRepository extends JpaRepository<CuentaCorrienteIngresos, Long>{
    
}
