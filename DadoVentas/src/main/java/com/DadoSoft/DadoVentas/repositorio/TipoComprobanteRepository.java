package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.TipoComprobante;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TipoComprobanteRepository extends JpaRepository<TipoComprobante, Long> {

    @Query("select c from TipoComprobante c where c.comprobante= :parametro")
    public TipoComprobante buscarNombreComprobante(@Param("parametro") String parametro);

}
