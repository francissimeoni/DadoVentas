package com.DadoSoft.DadoVentas.Entidades;

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
@ToString
@Entity
public class FinanciacionPropia {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idFinanciacion;
    private int ticket;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;
    
    
    

}
