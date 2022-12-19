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
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class Configuracion {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idconfiguracion;

    private String nombreEmpresa;
    private Imagenes imagen;

    @OneToOne
    @JoinColumn(name = "idCondicion")
    private CondicionIva condicionIva;

    private String IIBB;
    private String inicioDeActividad;
    private String cai;
    private String nombreDeFantasía;

    private String productKey;

    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String cp;

    private String correoElectronico;

    private String telefonoMovil;
    private String telefonoMovi2;
    private String telefonoMovi3;
    private String telefonoMovi4;

    private String telefonoFijo1;
    private String telefonoFijo2;
    private String telefonoFijo3;
    private String telefonoFijo4;

    private String redSocial1;
    private String redSocial2;
    private String redSocial3;
    private String redSocial4;

    private Integer ticketVenta;
    private Integer ticketRemito;
    private Integer ticketPresupuesto;
    private Integer ticketNotaDeCredito;
    private Integer ticketNotaDeDebito;

}
