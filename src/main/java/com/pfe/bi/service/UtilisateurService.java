package com.pfe.bi.service;

import java.util.List;
import java.util.Optional;

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
		
	public String returnLogin(Utilisateur utilisateurAVerifiee) {
		if (utilisateurAVerifiee.getNom_utilisateur().equals("admin") &&
				utilisateurAVerifiee.getMdps().equals("admin")){
				return "\"admin \"";
			}
			else if(utilisateurRepository.
					connexionUtilisateur(utilisateurAVerifiee.getNom_utilisateur()
					, utilisateurAVerifiee.getMdps())!= null)
				{ return "\"utilisateur \"";
				}
			else
			
			return "\"false \"";
	}

	public List<Utilisateur> findAllUtilisateur() {
		return utilisateurRepository.findAll();
	}

	public  Optional<Utilisateur> findById(Long idUtilisateur) {
		
		return utilisateurRepository.findById(idUtilisateur);
	}

	public Utilisateur utilisateur(Utilisateur utilisateurApresModification) {
		
		Utilisateur utilisateurEnvoyerBD=new Utilisateur();
		utilisateurEnvoyerBD.setNom_utilisateur(utilisateurApresModification.getNom_utilisateur());
		utilisateurEnvoyerBD.setMdps(utilisateurApresModification.getMdps());
		utilisateurEnvoyerBD.setEtat_compte(utilisateurApresModification.getEtat_compte());
		// A verifier
		utilisateurEnvoyerBD.setListePrivileges(utilisateurApresModification.getListePrivileges());

		return utilisateurEnvoyerBD;
	}

		
}
