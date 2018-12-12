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

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public long getId_client() {
		return id_client;
	}

	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Adresse> getAdresse() {
		return adresse;
	}

	public void setAdresse(Set<Adresse> adresse) {
		this.adresse = adresse;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + (int) (id_client ^ (id_client >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (id_client != other.id_client)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	public boolean addAdresse (Collection<Adresse> newAdresse) {
		return this.adresse.addAll(newAdresse);
	}
	
}
