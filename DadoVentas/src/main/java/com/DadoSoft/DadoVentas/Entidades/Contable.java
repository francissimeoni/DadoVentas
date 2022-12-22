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
public class Contable {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idRegistro;
    private Integer ticket;
    private Date fecha;
    private double Ingreso;
    private double Egreso;
    private double ivaCompra;
    private double ivaVenta;
    private double iibb;
    private double monto;
    private String metodoDePago;
    
    

}
