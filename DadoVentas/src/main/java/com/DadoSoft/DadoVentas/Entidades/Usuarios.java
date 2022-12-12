
package com.DadoSoft.DadoVentas.Entidades;

import com.DadoSoft.DadoVentas.enums.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Usuarios {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idUsuario;
    private String Usuario;
    private String contraseña;
    private String Domicilio;
    private String Telefono;
    private String Email;
    private Boolean ComisionSiNo;
    private Boolean ActivoSiNo;

    @OneToOne
    @JoinColumn(name = "IdGerarquiaUsuario")
    private GerarquiaUsuario GerarquiaUsuario;

    @Enumerated(EnumType.STRING)
    private Rol Rol;

}
