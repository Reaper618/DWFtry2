package dao;

import config.DBConnection;
import model.Alumno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private Connection conn;

    public AlumnoDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Crear un nuevo Alumno
    public void addAlumno(Alumno alumno) {
        String sql = "INSERT INTO Alumno (nombreAlumno, fechaNacimiento, numeroTelefono, email, curso_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alumno.getNombreAlumno());
            stmt.setDate(2, new Date(alumno.getFechaNacimiento().getTime()));
            stmt.setString(3, alumno.getNumeroTelefono());
            stmt.setString(4, alumno.getEmail());
            stmt.setLong(5, alumno.getCursoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener un Alumno por ID
    public Alumno getAlumnoById(long id) {
        String sql = "SELECT * FROM Alumno WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombreAlumno(rs.getString("nombreAlumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                alumno.setNumeroTelefono(rs.getString("numeroTelefono"));
                alumno.setEmail(rs.getString("email"));
                alumno.setCursoId(rs.getLong("curso_id"));
                return alumno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los Alumnos por ID de curso
    public List<Alumno> getAlumnosByCursoId(long cursoId) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM Alumno WHERE curso_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, cursoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombreAlumno(rs.getString("nombreAlumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                alumno.setNumeroTelefono(rs.getString("numeroTelefono"));
                alumno.setEmail(rs.getString("email"));
                alumno.setCursoId(rs.getLong("curso_id"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    // Actualizar un Alumno
    public void updateAlumno(Alumno alumno) {
        String sql = "UPDATE Alumno SET nombreAlumno = ?, fechaNacimiento = ?, numeroTelefono = ?, email = ?, curso_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alumno.getNombreAlumno());
            stmt.setDate(2, new Date(alumno.getFechaNacimiento().getTime()));
            stmt.setString(3, alumno.getNumeroTelefono());
            stmt.setString(4, alumno.getEmail());
            stmt.setLong(5, alumno.getCursoId());
            stmt.setLong(6, alumno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un Alumno
    public void deleteAlumno(long id) {
        String sql = "DELETE FROM Alumno WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

