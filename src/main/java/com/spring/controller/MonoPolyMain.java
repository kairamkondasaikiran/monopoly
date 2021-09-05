package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonoPolyMain {

	@GetMapping("/monoployHome")
	public String monoployHome() {
		
		return "Monopoly.jsp";
	}
}
