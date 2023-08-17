package com.sakila_ex5_1.sakila_ex5_1.service;

import com.sakila_ex5_1.sakila_ex5_1.dto.CustomerDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final JdbcTemplate jdbcTemplate;
    public CustomerService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<CustomerDTO> getAllCustomers(){
        String sql = "SELECT customer.first_name, customer.last_name, address.address " +
                "From customer " +
                "JOIN address ON customer.address_id = address.address_id " +
                "JOIN rental ON customer.customer_id = rental.customer_id " +
                "where rental.rental_date > '2006-02-01' AND rental.rental_date < '2006-03-01'";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setFirst_name(rs.getString("first_name"));
            customerDTO.setLast_name(rs.getString("last_name"));
            customerDTO.setAddress(rs.getString("address"));

            return customerDTO;
        });
    }

}
