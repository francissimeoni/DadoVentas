

package com.DadoSoft.DadoVentas.Entidades;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class Clientes {

      @Id
    @GeneratedValue(generator = "uuid")
    private Long IdCliente;
    private String Dni;
    private String nombreCompleto;
    private String Domicilio;
    private String Localidad;
    private String Provincia;
    private String Pais;
    private String CodigoPostal;
    private String Telefono;
    private String Celular;
    private String Email;

    @Temporal(TemporalType.DATE)
    private Date FechaNacimiento;

    @Temporal(TemporalType.DATE)
    private Date FechaIngreso;

    Boolean SuspendeSiNo;
    private double Saldo;
    private double CreditoMinimo;
    private Boolean ActivoSiNo;

    @Temporal(TemporalType.DATE)
    private Calendar UltimoIngreso;

}
