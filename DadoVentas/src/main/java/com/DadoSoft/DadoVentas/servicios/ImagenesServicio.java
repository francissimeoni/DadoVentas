package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Imagenes;
import com.DadoSoft.DadoVentas.Entidades.Productos;
import com.DadoSoft.DadoVentas.repositorio.ImagenesRepository;
import com.DadoSoft.DadoVentas.repositorio.ProductosRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenesServicio {

    @Autowired
    ImagenesRepository iR;
    
    
    @Autowired
    ProductosRepository pR;

    public Boolean CargarImagenesProducto(List<MultipartFile> Archivo) throws IOException {

        try {

            Productos p = pR.ObtenerUltimoProducto();
            
            for (MultipartFile img : Archivo) {

                Imagenes imagen = new Imagenes();
                
                imagen.setMime(img.getContentType());
                imagen.setNombre(img.getName());
                imagen.setContenido(img.getBytes());
                imagen.setIdProducto(p.getIdProducto());

                iR.save(imagen);

            }

            return true;

        } catch (Exception e) {

            return false;
        }

    }

}
