
package com.DadoSoft.DadoVentas.repositorio;


import com.DadoSoft.DadoVentas.Entidades.Cheques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequesRepository extends JpaRepository<Cheques, Long>{
    
}
