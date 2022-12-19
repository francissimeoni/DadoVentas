package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Moneda;
import com.DadoSoft.DadoVentas.repositorio.MonedaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonedaServicio {

    @Autowired
    MonedaRepository mR;

    @Transactional
    public Boolean crearNuevaMoneda(String nombre) {
        return true;
    }

    @Transactional
    public Boolean editarMoneda(Long idMoneda, String nombre, float valorNominal) {

        Moneda m = new Moneda();
        Optional<Moneda> op = mR.findById(idMoneda);

        if (op.isPresent()) {
            m = op.get();
            m.setValorNominal(valorNominal);
            m.setMoneda(nombre);
            return true;
        } else {
            return false;
        }

    }

    public List<Moneda> traerTodasLasMonedas() {

        return mR.findAll();

    }

}
