package com.codingdojo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

//added controller annotation for spring boot to recognize

@Controller
public class MainController {
	
//	autowired annotation utilized to inject services
	
	@Autowired DojoService dojoService;
	@Autowired NinjaService ninjaService;
	
//	get routes
	
//	route to render page with form for new dojo
	
	@GetMapping("/dojos/new")
	
//	modelattribute notation injected with "dojo" to correspond with form modelattribute
	
	public String rNewDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
//	route to render page with dojo and its ninjas
	
	@GetMapping("/dojos/{id}")
	public String rShowDojo(
			
//			pathvariable id used to find dojo by id
			
			@PathVariable("id") Long id,
			Model model) {
		
//		dojo object added to model in order to generate on page
		
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showDojo.jsp";
	}
	
//	route to render page with form for new ninja
	
	@GetMapping("/ninjas/new")
	public String rNewNinja(@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		model.addAttribute("dojos", dojoService.getAllDojos());
		return "newNinja.jsp";
	}
//	post routes
	
//	route for handling form on new dojo page
	
//	RESTful routing utilized. Note: identical routes in get and post routing 
	
	@PostMapping("/dojos/new")
	public String pNewDojo(
			
//			error validation purposefully not utilized but just for this assignment
			
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/ninjas/new";
	}
	
//	route for handling form on new dojo page
	
	@PostMapping("/ninjas/new")
	public String pNewNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		Ninja newNinja = ninjaService.createNinja(ninja);
		return "redirect:/dojos/" + newNinja.getDojo().getId();
	}
	
}
