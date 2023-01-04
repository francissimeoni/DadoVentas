package com.DadoSoft.DadoVentas.repositorio;

import com.DadoSoft.DadoVentas.Entidades.DesgloceMetodosDePago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DesgloceMetodosDePagoRepository extends JpaRepository<DesgloceMetodosDePago, Long> {

    @Query("select m from MetodosDePago m where m.ticket= :parametro")
    public List<DesgloceMetodosDePago> buscarMovimientoPorTicket(@Param("parametro") Integer parametro);

}
