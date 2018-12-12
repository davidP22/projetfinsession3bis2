package com.session3.projetfinsession3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.session3.projetfinsession3.model.Adresse;
import com.session3.projetfinsession3.repository.AdresseRepository;

import co.simplon.springboot.apprenant.model.Apprenant;

@RestController
@RequestMapping("/api")
public class AdresseController {

	@Autowired
	private AdresseRepository adresseRepo;
	
	public AdresseController() {
		
	}
	
	//rechercher toutes les adresses
	
	@RequestMapping(value = "/adresse", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAdresse(){
		List<Adresse> listeAdresse = null;
		try {
			listeAdresse = adresseRepo.findAll();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listeAdresse);
	}
	
	//ajouter une adresse
	
	@RequestMapping(value = "/adresse", method = RequestMethod.GET)
	public ResponseEntity<?> addAdresse(@RequestBody Adresse adresse){
		Adresse resultAdresse = null;
		String adresseNom = adresse.getAdresseNom();
		if((adresseNom == null) || (adresseNom.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom de l'adresse!");
		
		String code_postal = adresse.getCode_postal();
		if((nom == null) || (nom.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le code postal !");
		
		String ville = adresse.getVille();
		if((ville == null) || (ville.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque la ville !");
		
		try {
			resultAdresse = adresseRepo.saveAndFlush(adresse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultAdresse);
	}
	
	//modifier une adresse
	
	@RequestMapping(value = "/adresse/{id_adresse}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateApprenant(@RequestBody Apprenant apprenant,@PathVariable Integer id) throws Exception {
		Apprenant resultApprenant = null;
		String prenom = apprenant.getPrenom();
		if((prenom == null) || (prenom.isEmpty()))
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le prénom !");
		
		String nom = apprenant.getNom();
		if((nom == null) || (nom.isEmpty()))
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom !");
		
		try {
			resultApprenant = apprenantRepository.save(apprenant);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(resultApprenant);
	}
}
