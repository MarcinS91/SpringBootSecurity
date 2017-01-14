package com.security.dao;

import java.util.List;

import com.security.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	Customer getCustomerById(int customerId);

	List<Customer> getAllCustomers();

	Customer getCustomerByUsername(String username);
}
