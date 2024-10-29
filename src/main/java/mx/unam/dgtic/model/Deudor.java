package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Deudor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_deudor;
    private String nombre;
    @Column(name = "apellido_pat")
    private String apellidoPat;
    @Column(name = "apellido_mat")
    private String apellidoMat;
    private String telefono;
    private String mail;

    public Deudor() {
    }

    public Deudor(String nombre, String apellidoMat, String apellidoPat, String telefono, String mail) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.telefono = telefono;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Deudor{" +
                "id_deudor=" + id_deudor +
                ", nombre='" + nombre + '\'' +
                ", apellidoPat='" + apellidoPat + '\'' +
                ", apellidoMat='" + apellidoMat + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }


}
