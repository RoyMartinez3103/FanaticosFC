package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idMarca;

    private String nombre;

    public Marca() {
    }


    public Marca(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id_marca=" + idMarca +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
