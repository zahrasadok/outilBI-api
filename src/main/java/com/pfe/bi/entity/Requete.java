package com.pfe.bi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requete", schema = "public")
public class Requete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom")
	private String nom;
	@Column(name = "description")
	private String description;
	@Column(name = "type")
	private String type;
	@Column(name = "id_utilisateur")
	private int id_utilisateur;

	public Requete(String nom, String description, String type, int id_utilisateur) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.id_utilisateur = id_utilisateur;
	}

	// constructeur vide OBLIGATOIRE pour la creation
	public Requete() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisteur(int id_utilisteur) {
		this.id_utilisateur = id_utilisteur;
	}

}
