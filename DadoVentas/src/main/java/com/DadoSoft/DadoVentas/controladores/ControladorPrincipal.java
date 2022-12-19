package com.DadoSoft.DadoVentas.controladores;

import com.DadoSoft.DadoVentas.Entidades.Categoria;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.servicios.CategoriaServicio;
import com.DadoSoft.DadoVentas.servicios.GerarquiaUsuarioServicio;
import com.DadoSoft.DadoVentas.servicios.UsuariosServicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@CrossOrigin("*")
public class ControladorPrincipal {

    @Autowired
    CategoriaServicio cS = new CategoriaServicio();

    @Autowired
    UsuariosServicio uS = new UsuariosServicio();

    @Autowired
    GerarquiaUsuarioServicio Gu = new GerarquiaUsuarioServicio();

    @GetMapping(value = "/pruebaController")
    public String HolaMundo() throws JsonProcessingException {

        Categoria c = new Categoria();
        ObjectMapper mapper = new ObjectMapper();

        c.setCategoria("marroquineria");
        c.setIdCategoria(Long.MAX_VALUE);

        String jsonStr = mapper.writeValueAsString(c);

        return jsonStr;

    }

    @GetMapping("/CargarCategoria")
    public void cargarCategoria(String categoria) throws MiExcepcion {
        String cat = "audio";
        cS.AgregarCategoria(cat);

    }

    @GetMapping("/ModificarCategoria")
    public void ModificarCategoria(String categoria) throws MiExcepcion {

        cS.ModificarCategoria(categoria);

    }

    @GetMapping("/ListarCategorias")
    public void ListarCategorias(String categoria) throws MiExcepcion {

        cS.RetornarCategorias();

    }

    @GetMapping("/CrearGerarquia")
    public void CrearGerarquia() {

        Gu.crearGerarquia();
        System.out.println("Gerarquia creada");

    }

}
