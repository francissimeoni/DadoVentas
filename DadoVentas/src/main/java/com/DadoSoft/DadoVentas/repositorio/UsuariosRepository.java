package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query("select u from Usuarios u where u.email= :parametro or u.usuario= :parametro")
    public Usuarios buscarPorEmailoUsuario(@Param("parametro") String parametro);

}
