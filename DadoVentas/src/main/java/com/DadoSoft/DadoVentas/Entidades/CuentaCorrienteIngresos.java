package com.DadoSoft.DadoVentas.Entidades;

import java.util.Date;
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
public class CuentaCorrienteIngresos {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idCCi;
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;
    private Integer ticket;
    private double debe;
    private double haber;
    private double saldo;

}
