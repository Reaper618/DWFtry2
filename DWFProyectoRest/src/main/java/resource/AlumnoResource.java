package resource;

import service.AlumnoService;
import model.Alumno;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/curso/{cursoId}/alumno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoResource {
    private AlumnoService alumnoService = new AlumnoService();

    // Obtener todos los alumnos de un curso
    @GET
    public Response getAlumnos(@PathParam("cursoId") long cursoId) {
        List<Alumno> alumnos = alumnoService.getAlumnosByCursoId(cursoId);
        if (alumnos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron alumnos para el curso con id " + cursoId).build();
        }
        return Response.ok(alumnos).build();
    }

    // Obtener un alumno específico por ID
    @GET
    @Path("/{alumnoId}")
    public Response getAlumno(@PathParam("cursoId") long cursoId, @PathParam("alumnoId") long alumnoId) {
        Alumno alumno = alumnoService.getAlumnoById(alumnoId);
        if (alumno == null || alumno.getCursoId() != cursoId) {
            return Response.status(Response.Status.NOT_FOUND).entity("Alumno no encontrado con id " + alumnoId + " en el curso con id " + cursoId).build();
        }
        return Response.ok(alumno).build();
    }

    // Crear un nuevo alumno
    @POST
    public Response addAlumno(@PathParam("cursoId") long cursoId, Alumno alumno) {
        alumno.setCursoId(cursoId);
        alumnoService.addAlumno(alumno);
        return Response.status(Response.Status.CREATED).entity(alumno).build();
    }

    // Actualizar un alumno existente
    @PUT
    @Path("/{alumnoId}")
    public Response updateAlumno(@PathParam("cursoId") long cursoId, @PathParam("alumnoId") long alumnoId, Alumno alumno) {
        Alumno existingAlumno = alumnoService.getAlumnoById(alumnoId);
        if (existingAlumno == null || existingAlumno.getCursoId() != cursoId) {
            return Response.status(Response.Status.NOT_FOUND).entity("Alumno no encontrado con id " + alumnoId + " en el curso con id " + cursoId).build();
        }
        alumno.setId(alumnoId);
        alumno.setCursoId(cursoId);
        alumnoService.updateAlumno(alumno);
        return Response.ok(alumno).build();
    }

    // Eliminar un alumno
    @DELETE
    @Path("/{alumnoId}")
    public Response deleteAlumno(@PathParam("cursoId") long cursoId, @PathParam("alumnoId") long alumnoId) {
        Alumno existingAlumno = alumnoService.getAlumnoById(alumnoId);
        if (existingAlumno == null || existingAlumno.getCursoId() != cursoId) {
            return Response.status(Response.Status.NOT_FOUND).entity("Alumno no encontrado con id " + alumnoId + " en el curso con id " + cursoId).build();
        }
        alumnoService.deleteAlumno(alumnoId);
        return Response.noContent().build();
    }
}
