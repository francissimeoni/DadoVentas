
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
    private String usuario;
    private String contraseña;
    private String domicilio;
    private String telefono;
    private String email;
    private Boolean comisionSiNo;
    private Boolean activoSiNo;

    @OneToOne
    @JoinColumn(name = "IdGerarquiaUsuario")
    private GerarquiaUsuario gerarquiaUsuario;

    @Enumerated(EnumType.STRING)
    private Rol rol;

}
