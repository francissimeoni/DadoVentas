package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Categoria;
import com.DadoSoft.DadoVentas.Exceciones.MiExcepcion;
import com.DadoSoft.DadoVentas.repositorio.CategoriaRepository;
import java.util.Map;
import java.util.TreeMap;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepository CR;

    @Transactional
    public void AgregarCategoria(String categoria) throws MiExcepcion {
        Categoria ObjCategoria = new Categoria();
        Validaciones(categoria);

        ObjCategoria.setCategoria(categoria);
        CR.save(ObjCategoria);

    }

    @Transactional
    public void ModificarCategoria(String categoria) throws MiExcepcion {
        Categoria ObjCategoria = new Categoria();
        Validaciones(categoria);
        ObjCategoria.setCategoria(categoria);
        CR.save(ObjCategoria);
    }

    public TreeMap<Integer, String> RetornarCategorias() {

        TreeMap<Integer, String> ListaCategorias;

        ListaCategorias = (TreeMap<Integer, String>) CR.findAll();

        for (Map.Entry<Integer, String> entry : ListaCategorias.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println("El valor es: " + key + ", y el nombre es: " + value);

        }

        return null;
    }

    public void Validaciones(String NombreDeCategoria) throws MiExcepcion {

        if (!NombreDeCategoria.equalsIgnoreCase("")) {

        } else {

            throw new MiExcepcion("El campo de nombre no puede ir vacio");

        }

    }

}
