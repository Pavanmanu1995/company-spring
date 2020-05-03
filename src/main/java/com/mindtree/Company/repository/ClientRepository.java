package com.mindtree.Company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Company.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
