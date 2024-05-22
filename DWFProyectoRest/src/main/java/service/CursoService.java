package service;

import dao.CursoDAO;
import model.Curso;

import java.util.List;

public class CursoService {
    private CursoDAO cursoDAO = new CursoDAO();

    // Obtener todos los cursos
    public List<Curso> getAllCursos() {
        return cursoDAO.getAllCursos();
    }

    // Obtener un curso por ID
    public Curso getCursoById(long id) {
        return cursoDAO.getCursoById(id);
    }

    // Crear un nuevo curso
    public void addCurso(Curso curso) {
        cursoDAO.addCurso(curso);
    }

    // Actualizar un curso existente
    public void updateCurso(Curso curso) {
        cursoDAO.updateCurso(curso);
    }

    // Eliminar un curso
    public void deleteCurso(long id) {
        cursoDAO.deleteCurso(id);
    }
}
