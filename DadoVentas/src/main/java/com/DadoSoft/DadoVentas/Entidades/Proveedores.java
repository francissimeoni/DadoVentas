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

public class Proveedores {

      @Id
    @GeneratedValue(generator = "uuid")
    private Long idProveedor;
    private String NombreProveedor;
    private String Cuit;
    private String IIBB;
    private String Domicilio;
    private String Localidad;
    private String Provincia;
    private String Pais;
    private Integer CodigoPostal;
    private String Telefono;
    private String Celular;
    private String Fax;
    private String Email;
}
