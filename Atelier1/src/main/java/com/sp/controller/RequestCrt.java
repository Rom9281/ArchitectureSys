 package com.sp.controller;

  import org.springframework.beans.factory.annotation.Value;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  
  @Controller // AND NOT @RestController
  public class RequestCrt {
  
  	@Value("${welcome.message}")
  	private String message;
  
  	private static String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
  
  	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  	public String index(Model model) {
    
  		model.addAttribute("message", message);
  		model.addAttribute("messageLocal", messageLocal);
  
  		return "index";
  	}
}

