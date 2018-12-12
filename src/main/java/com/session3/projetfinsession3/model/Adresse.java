package com.session3.projetfinsession3.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;




@Entity
@Table(name = "Adresse")
public class Adresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Adresse_ID")
	private long id_adresse;
	
	@Size(max = 100)
	@Column(name = "Adresse")
	private String adresse;
	
	@Size(max = 5)
	@Column(name = "Code_Postal")
	private String code_postal;
	
	@Size(max = 100)
	@Column(name = "Ville")
	private String ville;
	
	@ManyToOne
	@JoinColumn(name="Client_ID")
	private Client client;

	public Adresse( @Size(max = 100) String adresse, @Size(max = 5) String code_postal,
			@Size(max = 100) String ville, Client client) {
	
		
		this.adresse = adresse;
		this.code_postal = code_postal;
		this.ville = ville;
		this.client = client;
	}

	public Adresse() {
		
	}
	
	

	
	
	
	
}
