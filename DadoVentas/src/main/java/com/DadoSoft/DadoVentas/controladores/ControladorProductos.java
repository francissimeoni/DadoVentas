package com.DadoSoft.DadoVentas.controladores;

import com.DadoSoft.DadoVentas.Entidades.Categoria;
import com.DadoSoft.DadoVentas.Entidades.Marca;
import com.DadoSoft.DadoVentas.Entidades.Modelo;
import com.DadoSoft.DadoVentas.Entidades.Moneda;
import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.Rubro;
import com.DadoSoft.DadoVentas.Entidades.UnidadMedida;
import com.DadoSoft.DadoVentas.repositorio.ProductosRepository;
import com.DadoSoft.DadoVentas.servicios.ImagenesServicio;
import com.DadoSoft.DadoVentas.servicios.ProductosServicio;
import com.DadoSoft.DadoVentas.servicios.ProductosStockServicio;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
public class ControladorProductos {

    @Autowired
    ProductosServicio pS;

    @GetMapping("/nuevoProducto")
    public String nuevoProducto() {

        return "";

    }

    @GetMapping("/persistirProducto")
    public String persistirProducto(String productoNombre, String descripcionLarga, Rubro rubro, Categoria categoria, Marca marca, Modelo modelo, String codBarra, String codInterno, boolean activoSiNo, float precioCosto, Moneda moneda, float iva, UnidadMedida unidadMedida, float lista1, float lista2, float lista3, float lista4, float comision, Integer unidades, List<MultipartFile> Archivos) throws IOException {

        pS.CrearProducto(productoNombre, descripcionLarga, rubro, categoria, marca, modelo, codBarra, codInterno, activoSiNo, 0, moneda, 0, unidadMedida, 0, 0, 0, 0, 0, unidades, Archivos);
        return "todo ok!";

    }

}
