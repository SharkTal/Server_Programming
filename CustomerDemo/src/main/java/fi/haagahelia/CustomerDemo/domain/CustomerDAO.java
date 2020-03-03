package fi.haagahelia.CustomerDemo.domain;

import java.util.List;

public interface CustomerDAO {
	public void save(Customer customer);
	public Customer findCustomer(int  id);
	public List<Customer> findAll();
}
