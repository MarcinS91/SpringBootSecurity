package com.security.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.model.Customer;
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

	@RequestMapping("/customer")
	public String customerManagement(Model model) {
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);

		return "customerManagement";
	}
}
