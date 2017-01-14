package com.security.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.service.CustomerService;

@Controller
@RequestMapping("/home")
public class AdminHome {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
}
