package com.example.demo.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")

public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/output")
	public String output(Integer item1, Integer item2, Integer item3) {
		int totalAmount = (item1 + item2 + item3);
		int taxAmount = (int)((totalAmount) + (totalAmount * 0.1));
		application.setAttribute("taxFreeResult", totalAmount);
		application.setAttribute("taxResult", taxAmount);
		return "exam03-result";
	}

}
