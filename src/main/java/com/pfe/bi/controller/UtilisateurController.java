package com.pfe.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.repository.UtilisateurRepository;

@RestController
@RequestMapping("/user")
public class UtilisateurController {

	
	
	
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	// verifier l'existance de l'utilisateur (LOGIN)
	@RequestMapping("/utilisateurlogin/{nom_utilisateur}/{mdps}")
	public boolean rechercheParNom(@PathVariable(value ="nom_utilisateur") 
	String nom_utilisateur, @PathVariable(value ="mdps") 
	String mdps) 		
		throws NotFoundException {
		
			Utilisateur utilisateurRecherche = utilisateurRepository.
					connexionUtilisateur(nom_utilisateur
					, mdps);
					
		System.out.println("UtilisateurController: nom = "+nom_utilisateur+
				" mdps= "+mdps);
		return utilisateurRecherche != null;
		
	}
	

}