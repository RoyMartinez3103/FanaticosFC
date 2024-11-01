package mx.unam.dgtic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
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
    private LocalDate fechaNac;
    @Size(min = 13, max = 13, message = "El RFC debe tener exactamente 13 caracteres")
    private String rfc;
    @NotBlank(message = "El correo no puede estar vacío")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "El correo debe ser válido"
    )
    private String mail;
    private String username;
    @Size(min = 8, max = 13, message = "La contraseña debe tener entre 8 y 12 caracteres")
    @Column(name = "Contraseña")
    private String contrasena;
    @Column(name = "es_admin")
    private Boolean esAdmin;
    @Column(name = "ventas_realizadas")
    private Integer ventasRealizadas;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidoPat, String apellidoMat, LocalDate fechaNac, String rfc, String mail, String username, String contrasena, Boolean esAdmin, Integer ventasRealizadas) {
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

