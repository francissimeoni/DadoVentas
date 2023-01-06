package com.DadoSoft.DadoVentas.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;
    private double monto;
    private double iva;
    private String lista;
    private String anotacion;
    private double descuento;

    @OneToMany
    private ArrayList<ProductosExtendido> productos;
    private int numeroDeTicket;

}
