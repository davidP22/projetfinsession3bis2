package com.session3.projetfinsession3.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Client")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Client_ID")
	private long id_client;

	@Size(max = 255)
	@Column(name = "Nom")
	private String nom;

	@Size(max = 65)
	@Column(name = "Prenom")
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Adresse> adresse = new HashSet<Adresse>();

	public Client(@Size(max = 255) String nom, @Size(max = 65) String prenom) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = new HashSet<Adresse>();
	}

	public Client() {
		
	}
	
	public boolean addAdresse (Collection<Adresse> newAdresse) {
		return this.adresse.addAll(newAdresse);
	}

	
	

	
}
