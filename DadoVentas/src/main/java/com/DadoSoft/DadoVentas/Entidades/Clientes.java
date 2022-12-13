

package com.DadoSoft.DadoVentas.Entidades;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class Clientes {

      @Id
    @GeneratedValue(generator = "uuid")
    private Long idCliente;
    private String dni;
    private String nombreCompleto;
    private String domicilio;
    private String localidad;
    private String provincia;
    private String pais;
    private String codigoPostal;
    private String telefono;
    private String celular;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    Boolean suspendeSiNo;
    private double saldo;
    private double creditoMaximo;
    private Boolean activoSiNo;

    @Temporal(TemporalType.DATE)
    private Date ultimoIngreso;
    
    @OneToOne
    @JoinColumn(name = "idCondicion")
    private CondicionIva condicionIva;
    
    private String contraseña;

}
