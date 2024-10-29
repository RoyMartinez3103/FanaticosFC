package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_venta;
    @Column(name ="cantidad_playeras")
    private Integer cantidadPlayeras;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_playera")
    private Playera playera;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer cantidadPlayeras, Venta venta, Playera playera) {
        this.cantidadPlayeras = cantidadPlayeras;
        this.venta = venta;
        this.playera = playera;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalle_venta=" + id_detalle_venta +
                ", cantidadPlayeras=" + cantidadPlayeras +
                ", venta=" + venta +
                ", playera=" + playera +
                '}';
    }
}
