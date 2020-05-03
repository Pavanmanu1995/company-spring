package com.mindtree.Company.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Company.entity.Client;
import com.mindtree.Company.entity.Company;
import com.mindtree.Company.exception.service.custom.ClientEmptyException;
import com.mindtree.Company.exception.service.custom.CompanyNotFoundException;
import com.mindtree.Company.exception.service.custom.NoSuchClientException;
import com.mindtree.Company.repository.ClientRepository;
import com.mindtree.Company.repository.CompanyRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	

	@Override
	public Client addClientToCompany(Client client, long companyId) throws CompanyNotFoundException {
		Company company=companyRepository.findById(companyId).orElse(null);
		if(company!=null)
		{
			client.setCompany(company);
			clientRepository.save(client);
		}
		else
			throw new CompanyNotFoundException("company not present");
		return client;
	}


	@Override
	public Set<Client> getAllClients(long companyId) throws CompanyNotFoundException,ClientEmptyException {
		Company company=companyRepository.findById(companyId).orElse(null);
		Set<Client> clientList=null;
		if(company!=null)
		{
			clientList=company.getClientList();
		}
		else
			throw new CompanyNotFoundException("company not present");
		if(clientList.isEmpty())
		{
			throw new ClientEmptyException("client not present");
		}
		return clientList;
	}


	@Override
	public Client updateBudgetByClientId(long clientId, double newBudget) throws NoSuchClientException {
		Client client=this.clientRepository.findById(clientId).orElse(null);
		if(client!=null)
		{
			client.setBudget(newBudget);
			this.clientRepository.save(client);
		}
		else
			throw new NoSuchClientException("client not present");
		
		return client;
	}

}
