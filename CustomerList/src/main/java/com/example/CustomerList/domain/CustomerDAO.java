package com.example.CustomerList.domain;

import java.util.List;

public interface CustomerDAO {
	public void save(Customer customer);
	
	public Customer findOne(int id);
	
	public List<Customer> findAll();
}
