package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Clientes;
import com.DadoSoft.DadoVentas.Entidades.CondicionIva;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.repositorio.ClientesRepository;
import com.sun.corba.se.impl.logging.OMGSystemException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
public class ClientesServicio {

    @Autowired
    ClientesRepository cR;

    @Transactional
    public Boolean CrearCliente(String nombreCompleto, String dni, String domicilio, String localicad, String provincia, String codigoPostal,
            String telefono, String celular, String email, Date fechaNacimiento, Date fechaIngreso, Boolean suspendeSiNo,
            double saldo, double creditoMaximo, Date ultimoIngreso, CondicionIva condicionIva, String pais, String contraseña) throws MiExcepcion {

        validaciones(dni);

        Clientes c = new Clientes();

        try {

            c.setNombreCompleto(nombreCompleto);
            c.setDni(dni);
            c.setDomicilio(domicilio);
            c.setLocalidad(localicad);
            c.setProvincia(provincia);
            c.setPais(pais);
            c.setCodigoPostal(codigoPostal);
            c.setTelefono(telefono);
            c.setCelular(celular);
            c.setEmail(email);
            c.setFechaNacimiento(fechaNacimiento);
            c.setFechaIngreso(fechaIngreso);
            c.setSuspendeSiNo(suspendeSiNo);
            c.setSaldo(saldo);
            c.setCreditoMaximo(creditoMaximo);
            c.setUltimoIngreso(ultimoIngreso);
            c.setActivoSiNo(true);
            c.setCondicionIva(condicionIva);
            c.setContraseña(contraseña);

            cR.save(c);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Transactional
    public void actualizarUltimoIngreso(Long idCliente) {

        Clientes c = new Clientes();
        Optional<Clientes> op = cR.findById(idCliente);
        c = op.get();

        Date fecha = new Date();
        Integer año = fecha.getYear();
        Integer mes = fecha.getMonth();
        Integer dia = fecha.getDay() - 3;

        Date fechaEditada = new Date(año, mes, dia);

        c.setUltimoIngreso(fechaEditada);

        cR.save(c);

    }

    @Transactional
    public void activoSino(Long idCliente, Boolean estado) {

        Clientes c = new Clientes();
        Optional<Clientes> op = cR.findById(idCliente);
        c = op.get();

        c.setActivoSiNo(estado);

    }

    @Transactional
    public Boolean suspendeSino(Long idCliente, Boolean estado) {

        try {

            Clientes c = new Clientes();
            Optional<Clientes> op = cR.findById(idCliente);
            c = op.get();
            c.setSuspendeSiNo(estado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Date obtenerUltimoIngreso(Long idCliente) {

        Clientes c = new Clientes();
        Optional<Clientes> op = cR.findById(idCliente);
        c = op.get();

        return c.getUltimoIngreso();
    }

    public void validaciones(String dni) throws MiExcepcion {

        Clientes cliente = cR.buscarPordni(dni);

        if (cliente != null) {
            throw new MiExcepcion("El cliente ya existe.");
        }

    }

}
