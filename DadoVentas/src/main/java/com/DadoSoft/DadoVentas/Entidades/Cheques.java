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
public class Cheques {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idCheque;

    private Integer numeroCheque;
    
    //1 - recibido  .. 2- liberado
    private Integer recibidoLiberado;
    
    private Date fechaDeEmision;
    private Date fechaDeCobro;
    private double monto;
    private String vieneDe;
    private String entregadoA;
    
    
}
