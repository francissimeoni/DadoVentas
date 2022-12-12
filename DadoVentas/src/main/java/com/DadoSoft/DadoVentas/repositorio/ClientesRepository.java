package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    @Query("select c from Clientes c where c.email= :parametro")
    public Clientes buscarPorEmail(@Param("parametro") String parametro);

    @Query("select c from Clientes c where c.dni= :parametro")
    public Clientes buscarPordni(@Param("parametro") String parametro);

}
