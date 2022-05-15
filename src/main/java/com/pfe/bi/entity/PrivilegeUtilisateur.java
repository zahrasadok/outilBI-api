package com.pfe.bi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acceder", schema = "admin")
public class PrivilegeUtilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_utilisateur;
	private Long id_Privilege;
	
	public PrivilegeUtilisateur() {
		super();
	}
	
	public PrivilegeUtilisateur(Long id, Long id_utilisateur, Long id_Privilege) {
		super();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_Privilege = id_Privilege;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Long getId_Privilege() {
		return id_Privilege;
	}
	public void setId_Privilege(Long id_Privilege) {
		this.id_Privilege = id_Privilege;
	}
	
}
