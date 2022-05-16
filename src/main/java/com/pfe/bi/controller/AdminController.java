package com.pfe.bi.controller;


import java.util.List;


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
	public List<Utilisateur> recupererToutUtilisateurs() {
		return utilisateurService.findAllUtilisateur();
	}

		// creer nouvel utilisateur **done**
		@PostMapping("/utilisateur")
		public Utilisateur creerRequete(@RequestBody Utilisateur nouvelUtilisateur) {
			return utilisateurService.save(nouvelUtilisateur);
		}
		
		// récupere utilisateur avec id  **done**
		@GetMapping("/utilisateur/{id}")
		public Utilisateur recupererRequete(@PathVariable(name = "id") Long idUtilisateur)
				{
			Utilisateur utilisateurARechercher = utilisateurService.findById(idUtilisateur);
			return utilisateurARechercher;
		}
				
		// 	UpdateUserByID    **done**
		@PutMapping("/utilisateur/{id}")
		public ResponseEntity<Utilisateur> modifierRequete(@PathVariable(value = "id") Long idUtilisateur,
				@RequestBody Utilisateur utilisateurApresModification) throws ResourceNotFoundException {
			
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
		
		//  donner un privilege à un utilisateur **not working**
		@GetMapping("/privilegeUtilisateur/{id_utilisateur}/{id_privilege}")
		public String donnerPrivilege(@PathVariable Long id_utilisateur,
				@PathVariable Long id_privilege) {
			if(utilisateurService.ajouterPrivilegeUtilsateur(id_utilisateur, id_privilege))
			 return "\"updated\"";
			else return "\"failed\"";
		}
		
		// delete privilege from user **done**
		@GetMapping("/privilege/{id_utilisateur}/{id_privilege}")
		public String supprimerReqeute(@PathVariable(value = "id_utilisateur") Long id_utilisateur,
				@PathVariable(value = "id_privilege") Long id_privilege) {
		if(utilisateurService.enleverPrivilegeUtilsateur(id_utilisateur, id_privilege))
			 return "\"deleted\"";
			else return "\"failed\"";
		}
		
		// getAllprivilege  **done**
		@GetMapping("/tousPrivileges")
		public List<Privilege> recupererToutPrivilege() {
			return privilegeService.findAllPrivilege();
		}
 // 
 //	
}