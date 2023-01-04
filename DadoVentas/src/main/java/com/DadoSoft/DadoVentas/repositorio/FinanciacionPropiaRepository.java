
package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.FinanciacionPropia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanciacionPropiaRepository extends JpaRepository<FinanciacionPropia, Long>{
    
}
