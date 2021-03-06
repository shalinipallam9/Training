package com.db.spring.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db.spring.app.jdbc.ContactDAO;
import com.db.spring.app.model.Contact;
import com.db.spring.app.service.UserService;

@Controller
public class HomeController {
	
		
	@Autowired
	UserService userService;	
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public ModelAndView listContact(ModelAndView model) throws IOException{
	    List<Contact> listContact = userService.getContactlist();
	    model.addObject("listContact", listContact);
	    model.setViewName("home");
	 
	    return model;
	}

	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    Contact newContact = new Contact();
	    model.addObject("contact", newContact);
	    model.setViewName("ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		userService.saveOrUpdate(contact);
	    return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    userService.delete(contactId);
	    return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    Contact contact = userService.get(contactId);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("contact", contact);
	 
	    return model;
	}
}
