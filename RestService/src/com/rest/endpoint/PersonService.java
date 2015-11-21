package com.rest.endpoint;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.beans.Person;

@Path("person")
@Stateless
public class PersonService {

	@PersistenceContext
	EntityManager em;
	
	@GET
	public Response sayHello() {
		return Response.ok("Hello World!").build();
	}
	
	@GET
	@Path("/add/{name}/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloPerson(@PathParam("name") String name, @PathParam("age") int age) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		em.persist(p);
		return Response.ok(p).build();
	}
	
	@GET
	@Path("/getbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") long id) {
		Person p = em.find(Person.class, id);
		return Response.ok(p).build();
	}
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		TypedQuery<Person> q = em.createQuery("select p from Person p where p.id > 0", Person.class);
//		PersonList list = new PersonList(q.getResultList());
		List<Person> list = q.getResultList();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/del/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteById(@PathParam("id") long id) {
		Person p = em.find(Person.class, id);
		if (p != null) {
			em.remove(p);
			return Response.ok("Person with id " + id + " was delete succesffully!").build();
		}
		return Response.ok("Wrong id").build();
	}
	
	
}
