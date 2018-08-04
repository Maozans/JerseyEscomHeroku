package mx.com.ipn.escom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoService {
	
	private static Map<Integer, Alumno> alumnos = new HashMap<>();
	
	static{
		Alumno miguel = new Alumno(2011630513,"Miguel","Ochoa","ISC","miguelochoa1992@gmail.com");
		Alumno juan = new Alumno(2011630514,"Juan","Perez","Textil","juanjuan@gmail.com");
		
		alumnos.put(1,miguel);
		alumnos.put(2,juan);
	}
	
	/*
	 * Este metodo nos regresará la lista de todos los clientes
	 * existentes en la base de datos 
	 */
	
	@GET
	public List<Alumno> getAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/*
	 * Metodo para guardar un alumno nuevo y recibe como
	 * como parámetro un alumno
	 */
	@POST
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size()+1, alumno);
	}
	
	@DELETE
	@Path("/{alumnoId}")
	public void deleteAlumno(@PathParam("alumnoId") int id) {
		alumnos.remove(id);
	}
	
}
