package dao;

import config.DBConnection;
import model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private Connection conn;

    public CursoDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Crear un nuevo Curso
    public void addCurso(Curso curso) {
        String sql = "INSERT INTO Curso (nombreCurso, nombreProfesor, numeroTelefono, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getNombreProfesor());
            stmt.setString(3, curso.getNumeroTelefono());
            stmt.setString(4, curso.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener un Curso por ID
    public Curso getCursoById(long id) {
        String sql = "SELECT * FROM Curso WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getLong("id"));
                curso.setNombreCurso(rs.getString("nombreCurso"));
                curso.setNombreProfesor(rs.getString("nombreProfesor"));
                curso.setNumeroTelefono(rs.getString("numeroTelefono"));
                curso.setEmail(rs.getString("email"));
                return curso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los Cursos
    public List<Curso> getAllCursos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getLong("id"));
                curso.setNombreCurso(rs.getString("nombreCurso"));
                curso.setNombreProfesor(rs.getString("nombreProfesor"));
                curso.setNumeroTelefono(rs.getString("numeroTelefono"));
                curso.setEmail(rs.getString("email"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    // Actualizar un Curso
    public void updateCurso(Curso curso) {
        String sql = "UPDATE Curso SET nombreCurso = ?, nombreProfesor = ?, numeroTelefono = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getNombreProfesor());
            stmt.setString(3, curso.getNumeroTelefono());
            stmt.setString(4, curso.getEmail());
            stmt.setLong(5, curso.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un Curso
    public void deleteCurso(long id) {
        String sql = "DELETE FROM Curso WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

