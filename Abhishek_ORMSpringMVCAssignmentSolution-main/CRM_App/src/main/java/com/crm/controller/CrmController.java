package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entity.Customer;
import com.crm.service.CrmServices;

/**
 * This is the main controller of the application 
 * handles all the functional requests.
 * 
 * @author Shain Joy
 */

@Controller
@RequestMapping("/operations")
public class CrmController {

	@Autowired
	CrmServices crmServices;

	@RequestMapping("/addCustomer")
	public String addCust(Model custModel) {
		Customer customer = new Customer();
		custModel.addAttribute("Customer", customer);
		return "Customer-Form";
	}

	@RequestMapping("/list")
	public String listCustomers(Model custModel) {
		List<Customer> customers = crmServices.listAll();
		custModel.addAttribute("Customer", customers);
		return "List-Customers";
	}

	@RequestMapping("/update")
	public String updateOption(@RequestParam("customerId") int id, Model custModel) {
		Customer customer = crmServices.searchById(id);
		custModel.addAttribute("Customer", customer);
		return "Customer-Form";
	}

	/* Save mapping identifying the customer object as new or existing by checking the ID. 
	 * If ID is 0, new customer object will be created with respective parameter.
	 * If ID not 0, then it gets customer object from repository with the valid ID and 
	 * updates it.  
	 */
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer;
		if (id != 0) {
			customer = crmServices.searchById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		} else {
			customer = new Customer(firstName, lastName, email);
		}
		crmServices.save(customer);
		return "redirect:/operations/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		crmServices.deleteById(id);
		return "redirect:/operations/list";
	}

}
