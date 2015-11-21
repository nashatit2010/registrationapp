package com.rest.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import com.rest.endpoint.BankdbService;
import com.rest.endpoint.PersonService;
import com.rest.endpoint.StudentService;

@ApplicationPath("/api")
public class RestConfig extends Application {

	private Set<Class<?>> classes ;
	
	public RestConfig() {
		HashSet<Class<?>> set = new HashSet<>();
		set.add(PersonService.class);
		set.add(StudentService.class);
		set.add(JacksonFeature.class);
		set.add(BankdbService.class);
		
		classes = Collections.unmodifiableSet(set);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
	
}
