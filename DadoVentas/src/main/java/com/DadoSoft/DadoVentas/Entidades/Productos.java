package com.DadoSoft.DadoVentas.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private Long IdProducto;
    private String ProductoNombre;
    private String DescripcionLarga;
   
    private String idRubro;
    
    private String idCategoria;
   
    private String idMarca;
   
    private String idModelo;
    private String CodBarra;
    private String CodInterno;
    private boolean ActivoSiNo;
    private float PrecioCosto;
   
    private float idMoneda;
    private float iva;
   
    private Integer idUnidadMedida;
    private float Lista1;
    private float Lista2;
    private float Lista3;
    private float Lista4;
    private float Comision;
    
    private Integer idImagen;
    private float PorecentajeCalidad;

}
