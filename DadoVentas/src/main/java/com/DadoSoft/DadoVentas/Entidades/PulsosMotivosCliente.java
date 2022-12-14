package com.DadoSoft.DadoVentas.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class PulsosMotivosCliente {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idMotivo;
    private String Mensaje;
    private Integer Valor;
    private Boolean activoSiNo;

}
