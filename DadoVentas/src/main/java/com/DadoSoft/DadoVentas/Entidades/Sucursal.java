package com.DadoSoft.DadoVentas.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Sucursal {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idSucursal;
    private String nombreSucursal;
    private String domicilio;
    private String telefono;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios encargado;

}
