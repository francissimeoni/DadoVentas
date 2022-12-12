package com.DadoSoft.DadoVentas.Entidades;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class PulsosCliente {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long IdPulso;

    @ManyToOne()
    @JoinColumn(name = "IdUsuario")
    private Usuarios usuarios;

    @OneToOne
    @JoinColumn(name = "IdMotivo")
    private PulsosMotivosCliente pulsosmotivoscliente;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Clientes clientes;

    @Temporal(TemporalType.DATE)
    private Calendar Fecha;

}
