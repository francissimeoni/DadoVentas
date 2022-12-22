package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Clientes;
import com.DadoSoft.DadoVentas.Entidades.CuentaCorrienteIngresos;
import com.DadoSoft.DadoVentas.repositorio.ClientesRepository;
import com.DadoSoft.DadoVentas.repositorio.CuentaCorrienteIngresosRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CuentaCorrienteIngresoServicio {

    @Autowired
    ClientesRepository cR;

    @Autowired
    CuentaCorrienteIngresosRepository cciR;

    public Boolean persistirCuentaCorrienteIngresos(Integer Bandera, Long idCliente, float NuevoImporte, Integer ticket) {

        Optional<Clientes> op = cR.findById(idCliente);
//Bandera = 1 --> Debe
//Bandera = 2 --> Haber
        if (Bandera == 1) {

            if (op.isPresent()) {

                try {

                    if (chequearExistenciaCC(idCliente) == true) {

                        double saldo = saldoCliente(idCliente);
                        double nuevoImporte = saldo + NuevoImporte;

                        if (guardarSaldo(saldo, nuevoImporte, op.get(), ticket) == true) {
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        crearNuevaCuenta(op.get(), NuevoImporte, ticket);
                        return true;
                    }

                } catch (Exception e) {
                    return false;
                }
            } else {

            }

            return false;

        } else {

            Entrega(op.get(), NuevoImporte, ticket);
            return true;

        }

    }

    public void crearNuevaCuenta(Clientes cliente, double importe, Integer ticket) {

        Date fecha = new Date();
        Integer año = fecha.getYear();
        Integer mes = fecha.getMonth();
        Integer dia = fecha.getDay() - 3;

        Date fechaEditada = new Date(año, mes, dia);

        CuentaCorrienteIngresos cci = new CuentaCorrienteIngresos();
        cci.setCliente(cliente);
        cci.setDebe(importe);
        cci.setFecha(fechaEditada);
        cci.setHaber(0);
        cci.setSaldo(importe);
        cci.setTicket(ticket);

        cciR.save(cci);

    }

    public Boolean chequearExistenciaCC(Long idCliente) {

        Optional<CuentaCorrienteIngresos> op = cciR.findById(idCliente);

        if (op.isPresent()) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean guardarSaldo(double saldoAnterior, double importeTotal, Clientes cliente, Integer ticket) {

        Date fecha = new Date();
        Integer año = fecha.getYear();
        Integer mes = fecha.getMonth();
        Integer dia = fecha.getDay() - 3;

        Date fechaEditada = new Date(año, mes, dia);

        try {

            CuentaCorrienteIngresos cci = new CuentaCorrienteIngresos();
            cci.setCliente(cliente);
            cci.setDebe(saldoAnterior);
            cci.setFecha(fechaEditada);
            cci.setHaber(0);
            cci.setSaldo(importeTotal);
            cci.setTicket(ticket);

            cciR.save(cci);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public double saldoCliente(Long idCliente) {
        double saldo;
        Optional<Clientes> op = cR.findById(idCliente);

        if (op.isPresent()) {
            saldo = op.get().getSaldo();
            return saldo;

        } else {

            return 0.00;
        }

    }

    public void Entrega(Clientes cliente, double importe, Integer ticket) {

        Date fecha = new Date();
        Integer año = fecha.getYear();
        Integer mes = fecha.getMonth();
        Integer dia = fecha.getDay() - 3;

        Date fechaEditada = new Date(año, mes, dia);

        try {

            CuentaCorrienteIngresos cci = new CuentaCorrienteIngresos();
            cci.setCliente(cliente);
            cci.setDebe(0);
            cci.setFecha(fechaEditada);
            cci.setHaber(importe);
            cci.setSaldo(saldoCliente(cliente.getIdCliente()) - importe);
            cci.setTicket(ticket);

            cciR.save(cci);

        } catch (Exception e) {

        }

    }

}
