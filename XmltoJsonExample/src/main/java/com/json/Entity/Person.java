package com.json.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private String city;
	private String state;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Person [city=" + city + ", state=" + state + "]";
	}

}
