package com.example.springmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HiController {
	
	@RequestMapping("/hi")
	public String hi() {
		System.out.println("Hi Spring boot!");
		return "hi";
	}
	
	
}
