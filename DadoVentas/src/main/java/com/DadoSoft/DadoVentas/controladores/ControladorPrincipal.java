package com.DadoSoft.DadoVentas.controladores;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.servicios.CategoriaServicio;
import com.DadoSoft.DadoVentas.servicios.GerarquiaUsuarioServicio;
import com.DadoSoft.DadoVentas.servicios.UsuariosServicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControladorPrincipal {

    @Autowired
    CategoriaServicio cS = new CategoriaServicio();

    @Autowired
    UsuariosServicio uS = new UsuariosServicio();
    
    
    @Autowired
    GerarquiaUsuarioServicio Gu = new GerarquiaUsuarioServicio();

    @GetMapping("/pruebaController")
    public void HolaMundo() throws JsonProcessingException {

        System.out.println("Hasta aca llegué");

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
