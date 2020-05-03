package com.mindtree.Company.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Company.entity.Client;
import com.mindtree.Company.exception.service.custom.ClientEmptyException;
import com.mindtree.Company.exception.service.custom.CompanyNotFoundException;
import com.mindtree.Company.exception.service.custom.NoSuchClientException;
import com.mindtree.Company.repository.ClientRepository;
import com.mindtree.Company.repository.CompanyRepository;

@Service
public interface ClientService {
	
	

	Client addClientToCompany(Client client, long companyId) throws CompanyNotFoundException;

    Set<Client> getAllClients(long companyId) throws CompanyNotFoundException, ClientEmptyException;

	Client updateBudgetByClientId(long clientId, double newBudget) throws NoSuchClientException;

}
