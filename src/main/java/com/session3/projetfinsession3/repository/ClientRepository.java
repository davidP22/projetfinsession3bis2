package com.session3.projetfinsession3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.session3.projetfinsession3.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
