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
public class ProductosStock {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long id;

    private Long idProducto;
    private String productoNombre;
    private Integer cantidad;

}
