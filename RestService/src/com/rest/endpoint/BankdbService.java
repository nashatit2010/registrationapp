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

import com.rest.beans.Bankdb;
import com.rest.beans.Student;

@Path("/bank")
@Stateless
public class BankdbService {
		
	@PersistenceContext
	EntityManager em;
	
	@GET
	@Path("/validate/{account_no}/{account_pass}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateBankdb(@PathParam("account_no") long account_no,@PathParam("account_pass") long account_pass) {
		Bankdb b = em.find(Bankdb.class, account_no);
		if (b.getAccount_no() == account_no && b.getAccount_pass()==account_pass) {
			//	if (b != null) {
		return Response.ok(b).build();
		}
		return Response.serverError().build();
	}
	@GET
	@Path("/add/{name}/{pass}/{no}/{bla}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(@PathParam("name") String acc_name, @PathParam("pass") Long password,@PathParam("no") long acc_no, 
		@PathParam("bla") long blance) {
		Bankdb b = new Bankdb();
		b.setAccount_name(acc_name);
		b.setAccount_pass(password);
		b.setAccount_no(acc_no);
		b.setBlance(blance);
		
		em.persist(b);
		return Response.ok(b).build();
	}
	
	@GET
	@Path("/reger/{account}/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reger(@PathParam("account") long account_no, @PathParam("uid") long uid){
		Bankdb student_account = em.find(Bankdb.class, account_no);
		Bankdb bank = em.find(Bankdb.class, 2222);
		Student student = em.find(Student.class, uid);
		student_account.setBlance(student_account.getBlance() - student.getFees());
		bank.setBlance(bank.getBlance() + student.getFees());
		student.setStatus(true);
		em.flush();
		return Response.ok(student_account).build();
	}
	
/*	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		TypedQuery<Bankdb> b = em.createQuery("select b from Bankdb b where b.id > 0", Bankdb.class);
		List<Bankdb> list = b.getResultList();
		return Response.ok(list).build();
	}    */
	}

	


