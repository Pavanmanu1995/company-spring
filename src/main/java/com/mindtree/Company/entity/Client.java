package com.mindtree.Company.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clientId;
	private String clientName;
	private double budget;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	public Client() {
		super();
	}

	public Client(long clientId, String clientName, double budget, Company company) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.budget = budget;
		this.company = company;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", budget=" + budget + ", company="
				+ company + "]";
	}

	
	
	
	

}
