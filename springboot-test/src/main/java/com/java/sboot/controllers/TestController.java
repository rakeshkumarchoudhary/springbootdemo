package com.java.sboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.sboot.entity.Customer;

@RestController
public class TestController {

	@Autowired  
    JdbcTemplate jdbc;  
	
	@GetMapping
    @RequestMapping("/greeting")
    public String greeting() {
        return "welcome";
    }
    
    @PostMapping
    @RequestMapping("/addCustomer")  
    public String addCustomer(){  
        jdbc.execute("insert into customer(customer_name,customer_age,customer_address)values('Mohan Jha',34,'Patna')");  
        return"Customer created Successfully";  
    }
    
    @GetMapping
    @RequestMapping("/getCustomers")  
    public List<Customer> getCustomer(){  
    	List<Customer> custList = new ArrayList<Customer>();
    	Customer customer = null;
    	List<Map<String,Object>> customersList = jdbc.queryForList("select * from customer");
    	for(Map custMap: customersList)
    	{
    		customer = new Customer();
    		customer.setCustomerId(new Long((custMap.get("customer_id").toString())));
    		customer.setCustomerName((custMap.get("customer_name").toString()));
    		customer.setAge(Integer.parseInt(custMap.get("customer_age").toString()));
    		customer.setAddress((custMap.get("customer_address").toString()));
    		custList.add(customer);
    		
    		
    		
    	}
        return custList;  
    }

}
