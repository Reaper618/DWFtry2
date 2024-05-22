package model;

import java.io.Serializable;

public class Curso implements Serializable {
    private long id;
    private String nombreCurso;
    private String nombreProfesor;
    private String numeroTelefono;
    private String email;

    // Constructor vacío
    public Curso() {}

    // Constructor con parámetros
    public Curso(long id, String nombreCurso, String nombreProfesor, String numeroTelefono, String email) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
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

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", nombreProfesor='" + nombreProfesor + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
