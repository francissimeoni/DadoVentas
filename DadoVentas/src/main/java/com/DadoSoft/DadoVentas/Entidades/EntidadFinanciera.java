
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
public class EntidadFinanciera {
    
    
     
    @Id
    @GeneratedValue(generator = "uuid")
    private Long idEntidad;
    private String nombre;
}
