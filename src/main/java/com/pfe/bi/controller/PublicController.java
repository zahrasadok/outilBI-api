package com.pfe.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.service.UtilisateurService;

public class PublicController {

		@Autowired
		private UtilisateurService utilisateurService;
	
		// LOGIN **done**
		@PostMapping("/utilisateurlogin")
		public String login(@RequestBody Utilisateur utilisateurAVerifiee) 		
			throws NotFoundException {
			
			/* admin utilisateur false */
			return utilisateurService.returnLogin(utilisateurAVerifiee);
			
		}
}
