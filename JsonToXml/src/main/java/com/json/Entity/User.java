package com.json.Entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private String name;
	
	private String Address;

	private Person person;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String name, String address, Person person) {
		super();
		this.name = name;
		Address = address;
		this.person = person;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", Address=" + Address + ", person=" + person + "]";
	}

}
