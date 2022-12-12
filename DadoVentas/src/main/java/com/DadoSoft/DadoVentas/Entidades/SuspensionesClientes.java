
package com.DadoSoft.DadoVentas.Entidades;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class SuspensionesClientes {

      @Id
    @GeneratedValue(generator = "uuid")
    private Long IdSuspende;

    @Temporal(TemporalType.DATE)
    private Calendar Fecha;
    private String Mensaje;

   
    private Integer IdUsuario;
    
    private Integer IdCliente;
    
}
