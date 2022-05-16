package com.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.Card;


@Controller 
public class RequestCrtU {
	
	@RequestMapping(value = { "/cardForm" }, method = RequestMethod.GET)
	public String cardForm(Model model) {
		return "cardForm";
	}
	
	@RequestMapping(value = { "/addCard" }, method = RequestMethod.GET)
	public String cardForm(Card card) {
		return "cardForm";
	}
}