package com.DadoSoft.DadoVentas.controladores;

import com.DadoSoft.DadoVentas.Entidades.CondicionIva;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.servicios.ClientesServicio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientes")
public class ControladorClientes {

    @Autowired
    ClientesServicio cS;

    @GetMapping("/nuevoCliente")
    public void nuevoCliente() throws MiExcepcion {

        Date fecha = new Date();
        Integer año = fecha.getYear();
        Integer mes = fecha.getMonth();
        Integer dia = fecha.getDay() - 3;
        Date fechaIngreso = new Date(año, mes, dia);
        Date fechaNacimiento = new Date(1979, 05, 31);

        cS.CrearCliente("Francis Braian Simeoni", "35259602", "Brown 1671",
                "Reconquista", "Santa Fe", "3560", "430416", "3482-526395", "francissimeoni90@gmail.com", fechaNacimiento,
                fechaIngreso, false, 0.00, 0.00, fechaIngreso, null, "Argentina","Eduardo75");

    }

}
