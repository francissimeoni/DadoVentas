package com.DadoSoft.DadoVentas.Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class Ingresos {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idVenta;
    private Integer ticket;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;

    private double total;

    @ManyToOne
    @JoinColumn(name = "idDesgloceMetodo")
    private DesgloceMetodosDePago metodoDePago;

    @ManyToOne
    @JoinColumn(name = "idCategoriaIngreso")
    private CategoriaIngresos categoria;

    @ManyToOne
    @JoinColumn(name = "idRubroIngreso")
    private RubroIngresos rubro;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Caja caja;

}
