package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Integer idEquipo;

    private String nombre;
    private String pais;
    private String liga;

    public Equipo() {
    }

    public Equipo(String nombre, String pais, String liga) {
        this.nombre = nombre;
        this.pais = pais;
        this.liga = liga;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo='" + idEquipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", liga='" + liga + '\'' +
                '}';
    }


}
