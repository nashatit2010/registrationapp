package com.rest.endpoint;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.rest.beans.Student;

@Path("/students")
@Stateless
public class StudentService {
	
	@PersistenceContext
	EntityManager em;
	
	@GET
	@Path("/validate/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateStudent(@PathParam("uid") long uid) {
		Student s = em.find(Student.class, uid);
		if (s != null) {
			return Response.ok(s).build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Path("/add/{uid}/{n}/{d}/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent(@PathParam("uid") long uid, @PathParam("n") String name,@PathParam("d") String department, 
		@PathParam("f") int fees) {
		Student s = new Student();
		s.setUid(uid);
		s.setName(name);
		s.setdepartment(department);
		s.setFees(fees);
		
		em.persist(s);
		return Response.ok(s).build();
	}
    
}
