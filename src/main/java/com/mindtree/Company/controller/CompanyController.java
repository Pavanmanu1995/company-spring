package com.mindtree.Company.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Company.entity.Client;
import com.mindtree.Company.entity.Company;
import com.mindtree.Company.service.ClientService;
import com.mindtree.Company.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyservice;
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/add/to/company")
	public ResponseEntity<?> addToCompany(@RequestBody Company company)
	{
		return new ResponseEntity<Company>(this.companyservice.addToCompany(company),HttpStatus.CREATED);
	}
	
	
	

}
