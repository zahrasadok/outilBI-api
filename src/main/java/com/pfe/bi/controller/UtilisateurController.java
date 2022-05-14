package com.pfe.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.repository.UtilisateurRepository;
import com.pfe.bi.service.UtilisateurService;

@RestController
@RequestMapping("/user")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	// creer nouvel utilisateur **done
	@PostMapping("/utilisateur")
	public Utilisateur creerRequete(@RequestBody Utilisateur nouvelUtilisateur) {
		return utilisateurService.save(nouvelUtilisateur);
	}
	
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
	// LOGIN **done
	@PostMapping("/utilisateurlogin")
	public boolean login(@RequestBody Utilisateur utilisateurAVerifiee) 		
		throws NotFoundException {
		
			Utilisateur utilisateurRecherche = utilisateurRepository.
					connexionUtilisateur(utilisateurAVerifiee.getNom_utilisateur()
					, utilisateurAVerifiee.getMdps());
					
		System.out.println("UtilisateurController: nom = "+utilisateurAVerifiee.getNom_utilisateur()+
				" mdps= "+utilisateurAVerifiee.getMdps());
		return utilisateurRecherche != null;
		
	}

}