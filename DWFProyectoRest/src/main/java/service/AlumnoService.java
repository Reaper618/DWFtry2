package service;

import dao.AlumnoDAO;
import model.Alumno;

import java.util.List;

public class AlumnoService {
    private AlumnoDAO alumnoDAO = new AlumnoDAO();

    // Obtener todos los alumnos por ID de curso
    public List<Alumno> getAlumnosByCursoId(long cursoId) {
        return alumnoDAO.getAlumnosByCursoId(cursoId);
    }

    // Obtener un alumno por ID
    public Alumno getAlumnoById(long id) {
        return alumnoDAO.getAlumnoById(id);
    }

    // Crear un nuevo alumno
    public void addAlumno(Alumno alumno) {
        alumnoDAO.addAlumno(alumno);
    }

    // Actualizar un alumno existente
    public void updateAlumno(Alumno alumno) {
        alumnoDAO.updateAlumno(alumno);
    }

    // Eliminar un alumno
    public void deleteAlumno(long id) {
        alumnoDAO.deleteAlumno(id);
    }
}
