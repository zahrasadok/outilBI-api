package com.pfe.bi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
		private UtilisateurRepository utilisateurRepository;
		public Utilisateur save(Utilisateur utilisateur) {
			return utilisateurRepository.save(utilisateur);
		}
		
}
