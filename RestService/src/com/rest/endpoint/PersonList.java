package com.rest.endpoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.rest.beans.Person;

public class PersonList extends ArrayList<Person> {
	private static final long serialVersionUID = 1L;

	public PersonList() {
		super();
	}
	
	public PersonList(Collection<? extends Person> p) {
		super(p);
	}
	
	@XmlElement(name="person")
	public List<Person> getPerson() {
		return this;
	}

	public void setPerson(List<Person> p) {
		this.addAll(p);
	}

}
