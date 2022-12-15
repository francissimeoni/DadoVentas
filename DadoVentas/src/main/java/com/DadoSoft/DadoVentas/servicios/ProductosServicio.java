package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Categoria;
import com.DadoSoft.DadoVentas.Entidades.Marca;
import com.DadoSoft.DadoVentas.Entidades.Modelo;
import com.DadoSoft.DadoVentas.Entidades.Moneda;
import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.Entidades.Rubro;
import com.DadoSoft.DadoVentas.Entidades.UnidadMedida;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.repositorio.ProductosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductosServicio {

    @Autowired
    ProductosRepository pR;

    @Autowired
    ProductosStockServicio psS;

    @Autowired
    ImagenesServicio iS;

    public Boolean CrearProducto(String productoNombre, String descripcionLarga, Rubro rubro, Categoria categoria, Marca marca, Modelo modelo, String codBarra,
            String codInterno, boolean activoSiNo, float precioCosto, Moneda moneda, float iva, UnidadMedida unidadMedida, float lista1, float lista2, float lista3, float lista4,
            float comision, Integer unidades, List<MultipartFile> Archivos) {

        Productos p = new Productos();

        try {
            p.setProductoNombre(productoNombre);
            p.setDescripcionLarga(descripcionLarga);
            p.setRubro(rubro);
            p.setCategoria(categoria);
            p.setMarca(marca);
            p.setModelo(modelo);
            p.setCodBarra(codBarra);
            p.setCodInterno(codInterno);
            p.setActivoSiNo(activoSiNo);
            p.setPrecioCosto(precioCosto);
            p.setMoneda(moneda);
            p.setIva(iva);
            p.setUnidadMedida(unidadMedida);
            p.setLista1(lista1);
            p.setLista2(lista2);
            p.setLista3(lista3);
            p.setLista4(lista4);
            p.setComision(comision);

            pR.save(p);

            psS.CargarStock(unidades);
            if (!iS.CargarImagenesProducto(Archivos)) {
                throw new MiExcepcion("Hubo algun error al cargar las imagenes. ");
            }

            return true;

        } catch (Exception e) {

            return false;
        }

    }

}
