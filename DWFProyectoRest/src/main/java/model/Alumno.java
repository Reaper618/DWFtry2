package model;

import java.io.Serializable;
import java.util.Date;

public class Alumno implements Serializable {
    private long id;
    private String nombreAlumno;
    private Date fechaNacimiento;
    private String numeroTelefono;
    private String email;
    private long curso_id;

    // Constructor vacío
    public Alumno() {}

    // Constructor con parámetros
    public Alumno(long id, String nombreAlumno, Date fechaNacimiento, String numeroTelefono, String email, long curso_id) {
        this.id = id;
        this.nombreAlumno = nombreAlumno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.curso_id = curso_id;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCursoId() {
        return curso_id;
    }

    public void setCursoId(long curso_id) {
        this.curso_id = curso_id;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombreAlumno='" + nombreAlumno + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", email='" + email + '\'' +
                ", curso_id=" + curso_id +
                '}';
    }
}
