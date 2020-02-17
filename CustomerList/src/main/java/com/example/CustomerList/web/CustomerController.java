package com.example.CustomerList.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CustomerList.domain.Customer;
import com.example.CustomerList.domain.CustomerDAO;



@Controller
public class CustomerController {
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/customerlist")
	public String customerlist(Model model) {
		//Fetch all students
		List<Customer> customers = customerDAO.findAll();
		
		//Add customerlist to model and return view name
		model.addAttribute("customers", customers);
		
		return "customerlist";
		
	}
	
	// Add new customer
	@RequestMapping(value="/add")
	public String addStudent(Model model) {
		model.addAttribute("customer", new Customer());
		return "addcustomer";
	}
	
	//Save new customer
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Customer customer) {
		customerDAO.save(customer);
		return "redirect:customerlist";
	}
	
}
