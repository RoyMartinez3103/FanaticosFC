package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Estatus_venta")
public class EstatusVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estatus_venta;
    private String estatus;
    private String descripcion;

    public EstatusVenta() {
    }

    public EstatusVenta(String estatus, String descripcion) {
        this.estatus = estatus;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EstatusVenta{" +
                "id_estatus_venta=" + id_estatus_venta +
                ", estatus='" + estatus + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


}
