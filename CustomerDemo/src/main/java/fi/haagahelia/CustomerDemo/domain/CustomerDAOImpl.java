package fi.haagahelia.CustomerDemo.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save(Customer cus) {
		String sql = "insert into cus(first_name, last_name) values(?,?)";
		Object[] parameters = new Object[] { cus.getFirstName(),
				cus.getLastName() };
		
		jdbcTemplate.update(sql, parameters);
	}
	
	public Customer findCustomer(int id) {
		String sql = "select customer_id, first_name, last_name from customer where student_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Customer> mapper = new CustomerRowMapper();

		Customer customer = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return customer;
	}
	
	public List<Customer> findAll(){
		String sql = "select customer_id, first_name, last_name from customer";
		RowMapper<Customer> mapper = new CustomerRowMapper();
		List<Customer> cus = jdbcTemplate.query(sql, mapper);

		return cus;
	}
}
