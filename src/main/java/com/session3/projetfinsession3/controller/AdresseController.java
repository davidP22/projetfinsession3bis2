package com.session3.projetfinsession3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session3.projetfinsession3.repository.AdresseRepository;

@RestController
@RequestMapping("/api")
public class AdresseController {

	@Autowired
	private AdresseRepository adresseRepo;
	
	public AdresseController() {
		
	}
	
	@RequestMapping(value = "/adresse")
	
}
