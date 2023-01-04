package com.DadoSoft.DadoVentas.servicios;

import com.DadoSoft.DadoVentas.Entidades.Caja;
import com.DadoSoft.DadoVentas.Entidades.CategoriaIngresos;
import com.DadoSoft.DadoVentas.Entidades.Clientes;
import com.DadoSoft.DadoVentas.Entidades.Ingresos;
import com.DadoSoft.DadoVentas.Entidades.RubroIngresos;
import com.DadoSoft.DadoVentas.Entidades.Sucursal;
import com.DadoSoft.DadoVentas.Entidades.Usuarios;
import com.DadoSoft.DadoVentas.repositorio.IngresosRepository;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngresosServicio {

    @Autowired
    IngresosRepository iR;

    @Transactional
    public Boolean registrarNuevoIngreso(int ticket, Clientes cliente, Usuarios usuario,
            double total, CategoriaIngresos categoria, RubroIngresos rubro, Caja caja, Sucursal sucursal) {

        try {

            Date fecha = new Date();
            Integer año = fecha.getYear();
            Integer mes = fecha.getMonth();
            Integer dia = fecha.getDay() - 3;

            Date fechaEditada = new Date(año, mes, dia);

            Ingresos nuevoItem = new Ingresos();

            nuevoItem.setTicket(ticket);
            nuevoItem.setCaja(caja);
            nuevoItem.setCategoria(categoria);
            nuevoItem.setCliente(cliente);
            nuevoItem.setFecha(fechaEditada);
            nuevoItem.setRubro(rubro);
            nuevoItem.setTotal(total);
            nuevoItem.setUsuario(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
