package com.mindtree.Company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Company.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
