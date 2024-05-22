package resource;

import service.CursoService;
import model.Curso;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {
    private CursoService cursoService = new CursoService();

    // Obtener todos los cursos
    @GET
    public Response getAllCursos() {
        List<Curso> cursos = cursoService.getAllCursos();
        if (cursos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron cursos").build();
        }
        return Response.ok(cursos).build();
    }

    // Obtener un curso específico por ID
    @GET
    @Path("/{cursoId}")
    public Response getCurso(@PathParam("cursoId") long cursoId) {
        Curso curso = cursoService.getCursoById(cursoId);
        if (curso == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Curso no encontrado con id " + cursoId).build();
        }
        return Response.ok(curso).build();
    }

    // Crear un nuevo curso
    @POST
    public Response addCurso(Curso curso) {
        cursoService.addCurso(curso);
        return Response.status(Response.Status.CREATED).entity(curso).build();
    }

    // Actualizar un curso existente
    @PUT
    @Path("/{cursoId}")
    public Response updateCurso(@PathParam("cursoId") long cursoId, Curso curso) {
        Curso existingCurso = cursoService.getCursoById(cursoId);
        if (existingCurso == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Curso no encontrado con id " + cursoId).build();
        }
        curso.setId(cursoId);
        cursoService.updateCurso(curso);
        return Response.ok(curso).build();
    }

    // Eliminar un curso
    @DELETE
    @Path("/{cursoId}")
    public Response deleteCurso(@PathParam("cursoId") long cursoId) {
        Curso existingCurso = cursoService.getCursoById(cursoId);
        if (existingCurso == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Curso no encontrado con id " + cursoId).build();
        }
        cursoService.deleteCurso(cursoId);
        return Response.noContent().build();
    }
}
