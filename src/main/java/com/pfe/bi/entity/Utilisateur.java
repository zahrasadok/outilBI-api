package com.pfe.bi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "utilisateur", schema = "admin")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String nom_utilisateur;
	//@Column(name = "mdps") //mot de passe
	private String mdps;
	private String etat_compte;
	@ManyToMany
	@JoinTable(name="acceder", schema="admin")
	List<Privilege> listePrivileges= new ArrayList<>();
	//@Transient
	//ArrayList<PrivilegeUtilisateur> listePrivilegesUtilisateurs= new ArrayList<>();
	
	public Utilisateur() {
		super();		
	}
	
	public Utilisateur(Long id, String nom_utilisateur, String mdps, String etat_compte) {
		super();
		this.id = id;
		this.nom_utilisateur = nom_utilisateur;
		this.mdps = mdps;
		this.etat_compte = etat_compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_utilisateur() {
		return nom_utilisateur;
	}

	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}

	public String getMdps() {
		return mdps;
	}

	public void setMdps(String mdps) {
		this.mdps = mdps;
	}

	public String getEtat_compte() {
		return etat_compte;
	}

	public void setEtat_compte(String etat_compte) {
		this.etat_compte = etat_compte;
	}

	public List<Privilege> getListePrivileges() {
		return listePrivileges;
	}

	public void setListePrivileges(List<Privilege> listePrivileges) {
		this.listePrivileges = listePrivileges;
	}

	
}
