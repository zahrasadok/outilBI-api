package com.pfe.bi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.bi.entity.Privilege;
import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.service.PrivilegeService;
import com.pfe.bi.service.UtilisateurService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
		// récupérer tous les utilisateurs **done**
	
	@GetMapping("/tousUtilisateurs")
	public List<Utilisateur> recupererToutRequete() {
		return utilisateurService.findAllUtilisateur();
	}

		// creer nouvel utilisateur **List of privileges missing**
		@PostMapping("/utilisateur")
		public Utilisateur creerRequete(@RequestBody Utilisateur nouvelUtilisateur) {
			return utilisateurService.save(nouvelUtilisateur);
		}
		// récupere utilisateur avec id **done**
		@GetMapping("/utilisateur/{id}")
		public ResponseEntity<Utilisateur> recupererRequete(@PathVariable(name = "id") Long idUtilisateur)

				throws ResourceNotFoundException {
			Utilisateur utilisateurARechercher = utilisateurService.findById(idUtilisateur)
					.orElseThrow(() -> new ResourceNotFoundException(
							"RequeteController: RequeteController: Requete n'existe pas, id=" + idUtilisateur));
			return ResponseEntity.ok().body(utilisateurARechercher);
		}
				
		// 	UpdateUserByID   **A revoir**
		@PutMapping("/utilisateur/{id}")
		public ResponseEntity<Utilisateur> modifierRequete(@PathVariable(value = "id") Long idUtilisateur,
				@Valid @RequestBody Utilisateur utilisateurApresModification) throws ResourceNotFoundException {
			
			/*utilisateurService.findById(idUtilisateur)
					.orElseThrow(() -> new ResourceNotFoundException("RequeteController: Requete n'existe pas, id=" + idUtilisateur));
			*/
			return ResponseEntity.ok(utilisateurService.save(
					utilisateurService.utilisateur(utilisateurApresModification)));
		}
		
		//  ajouter privilege **done**
		@PostMapping("/privilege")
		public Privilege creerPrivilege(@RequestBody Privilege nouveauPrivilege) {
			return privilegeService.save(nouveauPrivilege);
		}
		
//  add privilege to user
// delete privilege from user
		// getAllprivilege  **done**
		@GetMapping("/tousPrivileges")
		public List<Privilege> recupererToutPrivilege() {
			return privilegeService.findAllPrivilege();
		}
 // 
 //	
}
