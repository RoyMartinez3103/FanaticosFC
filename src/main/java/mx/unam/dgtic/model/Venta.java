package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;
    @Column(name = "fecha_venta")
    private Double fechaVenta;
    @Column(name = "venta_credito")
    private Integer ventaCredito;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estatus_venta")
    private EstatusVenta estatusVenta;

    public Venta() {
    }

    public Venta(Double fechaVenta, Integer ventaCredito, Usuario usuario, EstatusVenta estatusVenta) {
        this.fechaVenta = fechaVenta;
        this.ventaCredito = ventaCredito;
        this.usuario = usuario;
        this.estatusVenta = estatusVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_venta=" + id_venta +
                ", fechaVenta=" + fechaVenta +
                ", ventaCredito=" + ventaCredito +
                ", usuario=" + usuario +
                ", estatusVenta=" + estatusVenta +
                '}';
    }
}
