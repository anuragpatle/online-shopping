package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc 2");
		return mv;
		
	}
	
	
	  /*@RequestMapping(value = {"/test"}) 
	  public ModelAndView test(@RequestParam(value = "greeting", required = false)String greeting) {
	  
	  if (greeting == null) { greeting = "default msg"; }
	  
	  ModelAndView mv = new ModelAndView("page"); 
	  mv.addObject("greeting", greeting); 
	  return mv;
	  
	  }*/
	 
	
	@RequestMapping(value = {"/test/{greeting}"})
	public ModelAndView test(@PathVariable(value = "greeting")String greeting) {
		
		if (greeting == null) {
			greeting = "default msg";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
		
	}
	
}
