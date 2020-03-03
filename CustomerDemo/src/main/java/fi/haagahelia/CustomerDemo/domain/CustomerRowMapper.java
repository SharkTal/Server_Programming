package fi.haagahelia.CustomerDemo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer cus = new Customer();
		cus.setFirstName(rs.getString("first_name"));
		cus.setLastName(rs.getString("last_name"));
		cus.setId(rs.getLong("student_id"));
		
		return cus;
	}
	
}
