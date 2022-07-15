package com.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.entity.Customer;

@Service
public interface CrmServices {

	public void save(Customer customer);
	
	public Customer searchById(int id);
	
	public void deleteById(int id);
	
	public List<Customer> listAll();
	
}
