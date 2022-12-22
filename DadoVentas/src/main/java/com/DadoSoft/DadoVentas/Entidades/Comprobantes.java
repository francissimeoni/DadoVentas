package com.DadoSoft.DadoVentas.Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter //Setter
@NoArgsConstructor //Constructor vacio
@ToString //Tostring
@Entity
public class Comprobantes {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long idComprobante;

    private Integer numeroComprobante;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idTipoDeComprobante")
    private TipoComprobante tipoDeComprobante;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedores proveedor;
}
