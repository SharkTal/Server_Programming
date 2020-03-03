package fi.haagahelia.CustomerDemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.CustomerDemo.domain.Customer;
import fi.haagahelia.CustomerDemo.domain.CustomerDAO;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDAO cusDAO;
	
	@RequestMapping(value="/customerlist")
	public String customerlist(Model model) {
		
		//Get all customers
		List<Customer> customers = cusDAO.findAll();
		//Add cuslist to model and return view name
		
		model.addAttribute("customers", customers);
		
		return "customerlist";
	}
	
}
