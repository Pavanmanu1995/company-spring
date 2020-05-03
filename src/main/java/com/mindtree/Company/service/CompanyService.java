package com.mindtree.Company.service;

import org.springframework.stereotype.Service;

import com.mindtree.Company.entity.Company;

@Service
public interface CompanyService {

	Company addToCompany(Company company);

}
