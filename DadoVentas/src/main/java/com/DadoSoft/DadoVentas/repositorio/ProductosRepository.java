package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM Productos order by desc limit 1")
    public Productos ObtenerUltimoProducto();

}
