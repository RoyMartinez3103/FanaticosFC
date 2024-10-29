package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


@NamedNativeQuery(
        name = "Playera.findPlayeraCostoMayorPromedio",
        query = "SELECT * FROM playera " +
                "WHERE precio_venta > (SELECT AVG(precio_venta) FROM PLAYERA) " +
                "ORDER BY precio_venta",
        resultClass = Playera.class
)
@NamedQuery(
        name="Playera.contarPlayeraColor",
        query = "SELECT COUNT(p) from Playera p WHERE p.color = :color"
)
@NamedQuery(
        name = "Playera.findByColor",
        query = "SELECT p FROM Playera p WHERE p.color = :color"
)
@NamedQuery(
        name = "Playera.findRangoPrecios",
        query = "SELECT p FROM Playera p WHERE p.precioVenta BETWEEN :precioMin AND :precioMax " +
                "ORDER BY p.precioVenta"
)


@Entity
@Data
public class Playera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_playera")
    private Integer idPlayera;

    private String color;
    private String talla;

    @Column(name = "tipo_manga")
    private String tipoManga;

    @Column(name = "precio_real")
    private Double precioReal;

    private Integer stock;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;



    public Playera() {
    }

    public Playera(String color, String talla, String tipoManga, Double precioReal, Integer stock, Double precioVenta, Marca marca, Equipo equipo) {
        this.color = color;
        this.talla = talla;
        this.tipoManga = tipoManga;
        this.precioReal = precioReal;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.marca = marca;
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Playera{" +
                "id_playera=" + idPlayera +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", tipoManga='" + tipoManga + '\'' +
                ", precioReal=" + precioReal +
                ", stock=" + stock +
                ", precioVenta=" + precioVenta +
                ", marca=" + marca +
                ", equipo=" + equipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playera playera)) return false;
        return Objects.equals(idPlayera, playera.idPlayera) && Objects.equals(color, playera.color) && Objects.equals(talla, playera.talla) && Objects.equals(tipoManga, playera.tipoManga) && Objects.equals(precioReal, playera.precioReal) && Objects.equals(stock, playera.stock) && Objects.equals(precioVenta, playera.precioVenta) && Objects.equals(marca, playera.marca) && Objects.equals(equipo, playera.equipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayera, color, talla, tipoManga, precioReal, stock, precioVenta, marca, equipo);
    }
}
