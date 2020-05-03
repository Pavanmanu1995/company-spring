package com.mindtree.Company.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long companyId;
	private String companyName;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="company")
	private Set<Client> clientList;

	public Company() {
		super();
	}

	public Company(long companyId, String companyName, Set<Client> clientList) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.clientList = clientList;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Client> getClientList() {
		return clientList;
	}

	public void setClientList(Set<Client> clientList) {
		this.clientList = clientList;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", clientList=" + clientList + "]";
	}
	
	

}
