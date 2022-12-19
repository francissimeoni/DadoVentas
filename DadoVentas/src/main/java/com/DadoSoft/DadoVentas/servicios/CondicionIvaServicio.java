package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.CondicionIva;
import com.DadoSoft.DadoVentas.Entidades.Rubro;
import com.DadoSoft.DadoVentas.repositorio.CondicionIvaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondicionIvaServicio {

    @Autowired
    CondicionIvaRepository ciR;

    @Transactional
    public Boolean crearNuevacondicion(String nombre) {

        CondicionIva ci = new CondicionIva();

        try {
            ci.setNombre(nombre);
            ciR.save(ci);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    @Transactional
    public Boolean editarCondicion(Long idCondicionIva, String Condicion) {

        CondicionIva cI = new CondicionIva();
        Optional<CondicionIva> op = ciR.findById(idCondicionIva);

        if (op.isPresent()) {
            cI = op.get();
            cI.setNombre(Condicion);
            ciR.save(cI);
            return true;
        } else {
            return false;
        }

    }

    public List<CondicionIva> traerTodasLasCondiciones() {

        return ciR.findAll();

    }

    @Transactional
    public Boolean ActivarDesactivarCondicionIva(Long idCondicionIva, Boolean nuevoEstado) {
        CondicionIva cI = new CondicionIva();
        Optional<CondicionIva> op = ciR.findById(idCondicionIva);

        if (op.isPresent()) {
            cI = op.get();
            cI.setActivoSiNo(nuevoEstado);
            ciR.save(cI);
            return true;
        } else {
            return false;
        }

    }

}
