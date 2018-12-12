package com.session3.projetfinsession3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.session3.projetfinsession3.model.Client;


@RestController
@RequestMapping("/api")
public class Pfs3Controller {
	
	@Autowired
	private com.session3.projetfinsession3.repository.ClientRepository clientRepository;
	
	public Pfs3Controller() {}
		
		/**
		 * Retourner tous les clients
		 * @return
		 */
		
		@RequestMapping(value = "/client", method = RequestMethod.GET)
		public ResponseEntity<?> getAllClient(){
			List<Client> listeClients = null;
			try {
				listeClients = clientRepository.findAll();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(listeClients);
		
		
		
		
	}
	
	

}
