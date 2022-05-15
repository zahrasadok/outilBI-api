package com.pfe.bi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.pfe.bi.entity.Privilege;
import com.pfe.bi.entity.PrivilegeUtilisateur;
import com.pfe.bi.repository.PrivilegeUtilisateurRepository;

@Service
public class PrivilegeUtilisateurService {

	@Autowired
	PrivilegeUtilisateurRepository privilegeUtlisateurRepository;
	

	public ArrayList<Privilege> listePrivilegeUtilisateur(Long id_utilisateur) {
		return (ArrayList<Privilege>)
				privilegeUtlisateurRepository.tousPriviligeDUnUtilisateur(id_utilisateur);
	}


	public PrivilegeUtilisateur save(PrivilegeUtilisateur nouvelPrivilege) {
		return privilegeUtlisateurRepository.save(nouvelPrivilege);		 
	}


	public void delete(Long id_utilisateur, Long id_privilege) {
		//récuperer le privilige de la table acceder avec les 2 id
		PrivilegeUtilisateur recupereDeBD = privilegeUtlisateurRepository.
				retirerPrivilegeUtilisateur(id_utilisateur, id_privilege)
				.orElseThrow(() -> new ResourceNotFoundException());
		privilegeUtlisateurRepository.delete(recupereDeBD);
		}

}
