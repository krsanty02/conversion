package com.json.controller;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.json.Entity.User;
@RestController
public class UserController {
	@PostMapping(value="/getUser")
	public String getUser(@ RequestBody User user) throws JAXBException {
		System.out.println("11111111111111");
		System.out.println(user.getPerson().getCity());
		/*
		 * JSONObject obj = new JSONObject(user); String xml=XML.toString(obj);
		 * System.out.println(xml);
		 */
		
		JAXBContext jaxbContext     = JAXBContext.newInstance( User.class );
		Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(user, sw);
		String xmlString = sw.toString();
		return xmlString;
		
	}

}
