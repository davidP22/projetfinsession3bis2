package com.session3.projetfinsession3;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.session3.projetfinsession3.model.Adresse;
import com.session3.projetfinsession3.model.Client;
import com.session3.projetfinsession3.repository.AdresseRepository;
import com.session3.projetfinsession3.repository.ClientRepository;

@SpringBootApplication
public class Projetfinsession3Application {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private AdresseRepository adresseRepo;

	public static void main(String[] args) {
		SpringApplication.run(Projetfinsession3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Client cli1 = new Client("Martin", "Jean");
		Client cli2 = new Client("Schmith", "Leon");
		
		Adresse ad1 = new Adresse("23 rue des plantes", "75400", "Paris", cli1);
		Adresse ad2 = new Adresse("4 rue de la foret", "75400", "Paris", cli2);
		Adresse ad3 = new Adresse("5 rue des plantes", "75300", "Paris", cli1);
		
		Collection<Adresse> listAdresse1 = Arrays.asList(ad1, ad3);
		cli1.addAdresse(listAdresse1);
		
		Collection<Adresse> listAdresse2 = Arrays.asList(ad2);
		cli1.addAdresse(listAdresse2);
		
		
		clientRepo.save(cli1);
		clientRepo.save(cli2);
		adresseRepo.save(ad1);
		adresseRepo.save(ad2);
		adresseRepo.save(ad3);
	}
}
