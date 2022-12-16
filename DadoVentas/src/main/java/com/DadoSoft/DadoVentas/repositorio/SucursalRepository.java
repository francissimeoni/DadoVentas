package com.DadoSoft.DadoVentas.repositorio;
import com.DadoSoft.DadoVentas.Entidades.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    
}
