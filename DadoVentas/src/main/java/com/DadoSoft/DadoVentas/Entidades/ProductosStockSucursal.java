package com.DadoSoft.DadoVentas.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class ProductosStockSucursal {

    @Id
    @OneToOne
    @JoinColumn(name = "idProducto")
    private Productos producto;
    private int cantidadMinima;
    private int cantidad;
        
    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

}
