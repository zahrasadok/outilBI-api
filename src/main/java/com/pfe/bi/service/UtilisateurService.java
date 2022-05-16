package com.pfe.bi.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.bi.entity.Privilege;
import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.repository.PrivilegeRepository;
import com.pfe.bi.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	
	@Autowired
		private UtilisateurRepository utilisateurRepository;
	@Autowired
		private PrivilegeRepository privilegeRepository;
		
	//ajouter un nouvel utilisateur
		
	public Utilisateur save(Utilisateur utilisateur) {
					return utilisateurRepository.save(utilisateur);
		}
		
	//quoi retourner dans chaque cas (Login)
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

	public  Utilisateur findById(Long idUtilisateur) {
		if (utilisateurRepository.findById(idUtilisateur).isPresent())
		return utilisateurRepository.findById(idUtilisateur).get();
		else return null;
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

	// ajouter un privilege à un utilisateur
	public boolean ajouterPrivilegeUtilsateur(Long id_utilisateur,
			Long id_privilege)	{
		try {
		Privilege privilege= privilegeRepository.getById(id_privilege);
		Utilisateur utilisateur= utilisateurRepository.getById(id_utilisateur);
		List<Privilege> listeAcceder=new LinkedList<>(utilisateur.getListePrivileges());
		listeAcceder.add(privilege);
		utilisateur.setListePrivileges(listeAcceder);
		utilisateurRepository.save(utilisateur);
		return true;}
		catch (Exception e) {
			return false;
		}
	}
	
	// supprimer un privilege à un utilisateur
		public boolean enleverPrivilegeUtilsateur(Long id_utilisateur,
				Long id_privilege)	{
			try {
			Privilege privilege= privilegeRepository.getById(id_privilege);
			Utilisateur utilisateur= utilisateurRepository.getById(id_utilisateur);
			List<Privilege> listeAcceder=new LinkedList<>(utilisateur.getListePrivileges());
			listeAcceder.add(privilege);
			utilisateur.setListePrivileges(listeAcceder);
			utilisateurRepository.delete(utilisateur);
			return true;}
			catch (Exception e) {
				return false;
			}
		}
}
