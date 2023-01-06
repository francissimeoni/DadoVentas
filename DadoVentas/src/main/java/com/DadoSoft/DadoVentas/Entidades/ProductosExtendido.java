
package com.DadoSoft.DadoVentas.Entidades;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class ProductosExtendido extends Productos{
    
    private int cantidad;
    private double precio;
    
    
    
}
