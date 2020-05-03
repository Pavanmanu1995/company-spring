package com.mindtree.Company.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Company.entity.Client;
import com.mindtree.Company.exception.service.custom.ClientEmptyException;
import com.mindtree.Company.exception.service.custom.CompanyNotFoundException;
import com.mindtree.Company.exception.service.custom.NoSuchClientException;
import com.mindtree.Company.service.ClientService;
import com.mindtree.Company.service.CompanyService;

@RestController
public class ClientController {
	
	@Autowired
	CompanyService companyservice;
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/addClientToCompany/{companyId}")
	public ResponseEntity<?> addClientToCompany(@RequestBody Client client,@PathVariable long companyId)
	{
		try {
			return new ResponseEntity<Client>(this.clientService.addClientToCompany(client,companyId),HttpStatus.CREATED);
		} catch (CompanyNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllClients/{companyId}")
	public ResponseEntity<?> getAllClients(@PathVariable long companyId)
	{
		try {
			return new ResponseEntity<Set<Client>>(this.clientService.getAllClients(companyId),HttpStatus.CREATED);
		} catch (CompanyNotFoundException | ClientEmptyException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{clientId}/{newBudget}")
	public ResponseEntity<?> updateBudgetByClientId(@PathVariable long clientId,@PathVariable double newBudget)
	{
		try {
			return new ResponseEntity<Client>(this.clientService.updateBudgetByClientId(clientId,newBudget),HttpStatus.CREATED);
		} catch (NoSuchClientException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CREATED);
		}
	}
	

}
