package com.mindtree.Company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Company.entity.Company;
import com.mindtree.Company.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company addToCompany(Company company) {
		
		return this.companyRepository.save(company);
	}

}
