package com.javasampleapproach.jquerydelete.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jquerydelete.model.Address;
import com.javasampleapproach.jquerydelete.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class RestAPIs {
Map<String, Customer> custStores = new HashMap<String, Customer>();
	
	@PostConstruct
    public void initIt() throws Exception {
        custStores.put("001", new Customer("001", "Jack", 25, new Address("NANTERRE CT", "77471")));
        custStores.put("002", new Customer("002", "Mary", 37, new Address("W NORMA ST", "77009")));
        custStores.put("003", new Customer("003", "Peter", 18, new Address("S NUGENT AVE", "77571")));
        custStores.put("004", new Customer("004", "Amos", 23, new Address("E NAVAHO TRL", "77449")));
        custStores.put("005", new Customer("005", "Craig", 45, new Address("AVE N", "77587")));
    }
	 
	@GetMapping(value = "/all")
	public List<Customer> getResource() {
		
		List<Customer> custList = custStores.entrySet().stream()
		        .map(entry -> entry.getValue())
		        .collect(Collectors.toList());
		
		return custList;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteCustomer(@PathVariable String id) {
		
		custStores.remove(id);
		return "OK!";
	}
}
