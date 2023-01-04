package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.DesgloceMetodosDePago;
import com.DadoSoft.DadoVentas.Entidades.MetodosDePago;
import com.DadoSoft.DadoVentas.repositorio.DesgloceMetodosDePagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DesgloceMetodosDePagoServicio {

    @Autowired
    DesgloceMetodosDePagoRepository dmpR;

    @Transactional
    public Boolean persistirNuevoItem(int ticket, MetodosDePago metodoDePago, double monto) {

        try {
            DesgloceMetodosDePago nuevoItem = new DesgloceMetodosDePago();

            nuevoItem.setMetodoDePago(metodoDePago);
            nuevoItem.setMonto(monto);
            nuevoItem.setTicket(ticket);

            dmpR.save(nuevoItem);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<DesgloceMetodosDePago> traerMovimientoPorId(int ticket) {

        return dmpR.buscarMovimientoPorTicket(ticket);

    }

}
