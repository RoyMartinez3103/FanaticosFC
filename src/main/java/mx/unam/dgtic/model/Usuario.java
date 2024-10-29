package mx.unam.dgtic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@NamedQuery(
        name = "Usuario.searchByFechaNacimientoAlfabetico",
        query = "SELECT a FROM Usuario a " +
                "WHERE a.fechaNac  BETWEEN :fechaIni AND :fechaFin "+
                "ORDER BY a.nombre"
)
@NamedQuery(
        name = "Usuario.contarPorRfcContenga",
        query = "SELECT COUNT(a) FROM Usuario a WHERE a.rfc LIKE CONCAT('%', :substring, '%')"
)
@NamedQuery(
        name = "Usuario.buscarPorRfcContenga",
        query = "SELECT a FROM Usuario a WHERE a.rfc LIKE CONCAT('%', :substring, '%')"
)


@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    private String nombre;
    @Column(name = "apellido_pat")
    private String apellidoPat;
    @Column(name = "apellido_mat")
    private String apellidoMat;
    @Column(name = "fecha_nac")
    private Date fechaNac;
    private String rfc;
    private String mail;
    private String username;
    @Column(name = "Contraseña")
    private String contrasena;
    @Column(name = "es_admin")
    private Boolean esAdmin;
    @Column(name = "ventas_realizadas")
    private Integer ventasRealizadas;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidoPat, String apellidoMat, Date fechaNac, String rfc, String mail, String username, String contrasena, Boolean esAdmin, Integer ventasRealizadas) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.fechaNac = fechaNac;
        this.rfc = rfc;
        this.mail = mail;
        this.username = username;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellidoPat='" + apellidoPat + '\'' +
                ", apellidoMat='" + apellidoMat + '\'' +
                ", fechaNac=" + fechaNac +
                ", rfc='" + rfc + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", esAdmin=" + esAdmin +
                ", ventasRealizadas=" + ventasRealizadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUsuario);
    }
}

