
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
public class MetodosDePago {
    
    
    @Id
    @GeneratedValue(generator = "uuid")
    private Long idMetodo;
    private String nombre;
    
}
