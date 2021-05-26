package com.json.controller;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.json.Entity.Person;
import com.json.Entity.User;
@RestController
public class UserController {
	@PostMapping(value="/getUser")
	public String getUser(@ RequestBody String xml) {
		System.out.println("11111111111111");
		System.out.println(xml);
		JAXBContext jaxbContext;
		  String jsonString="";
		  String xmlString="";
			try {
				jaxbContext = JAXBContext.newInstance( User.class );
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
						
				 
			    User user =
			    		 (User) jaxbUnmarshaller.unmarshal(new StringReader(xml));
			    System.out.println(user.toString());
			    
			   // JAXBContext jaxbContext     = JAXBContext.newInstance( User.class );
			/*
			 * Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 * StringWriter sw = new StringWriter(); jaxbMarshaller.marshal(user, sw);
			 * xmlString = sw.toString();
			 */
			    
			    Gson gson = new Gson();
		        
		       jsonString = gson.toJson(user);
		        System.out.println(jsonString);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return xmlString;
	
	}

}
