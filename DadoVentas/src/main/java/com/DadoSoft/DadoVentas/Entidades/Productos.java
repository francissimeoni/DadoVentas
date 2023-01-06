package com.DadoSoft.DadoVentas.Entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Productos {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idProducto;
    private String productoNombre;
    private String descripcionLarga;

    @OneToOne
    @JoinColumn(name = "idRubro")
    private Rubro rubro;

    @OneToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @OneToOne
    @JoinColumn(name = "idModelo")
    private Modelo modelo;
    private String codBarra;
    private String codInterno;
    private boolean activoSiNo;
    private float precioCosto;

    @OneToOne
    @JoinColumn(name = "idMoneda")
    private Moneda moneda;
    private float iva;

    @OneToOne
    @JoinColumn(name = "idUnidadDeMedida")
    private UnidadMedida unidadMedida;
    private float lista1;
    private float lista2;
    private float lista3;
    private float lista4;
    private float comision;
    private float PorecentajeCalidad;

}
