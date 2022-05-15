package com.pfe.bi.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.bi.entity.Privilege;
import com.pfe.bi.entity.PrivilegeUtilisateur;
import com.pfe.bi.entity.Utilisateur;
import com.pfe.bi.service.PrivilegeService;
import com.pfe.bi.service.PrivilegeUtilisateurService;
import com.pfe.bi.service.UtilisateurService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private PrivilegeUtilisateurService privilegeUtilisateurService;
	
		// récupérer tous les utilisateurs **done**
	@GetMapping("/tousUtilisateurs")
	public List<Utilisateur> recupererToutUtilisateurs() {
		
		//récuperer tous les utilisateurs
		List<Utilisateur> listUtilisateurs= utilisateurService.findAllUtilisateur();
		
		//associer la liste des privilige à chaque utilisateurs
		for (int i = 0; i < listUtilisateurs.size(); i++) {
			Utilisateur u=
			listUtilisateurs.get(i);
			u.setListePrivileges(privilegeUtilisateurService.
					listePrivilegeUtilisateur(u.getId()));	
		}
		return listUtilisateurs;
	}

		// creer nouvel utilisateur **done**
		@PostMapping("/utilisateur")
		public Utilisateur creerRequete(@RequestBody Utilisateur nouvelUtilisateur) {
			return utilisateurService.save(nouvelUtilisateur);
		}
		
		// récupere utilisateur avec id  **done**
		@GetMapping("/utilisateur/{id}")
		public ResponseEntity<Utilisateur> recupererRequete(@PathVariable(name = "id") Long idUtilisateur)

				throws ResourceNotFoundException {
			Utilisateur utilisateurARechercher = utilisateurService.findById(idUtilisateur)
					.orElseThrow(() -> new ResourceNotFoundException(
							"RequeteController: RequeteController: Requete n'existe pas, id=" + idUtilisateur));
			return ResponseEntity.ok().body(utilisateurARechercher);
		}
				
		// 	UpdateUserByID   **A revoir** **done**
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
		
		//  donner un privilege à un utilisateur **done**
		@PostMapping("/privilegeUtilisateur")
		public PrivilegeUtilisateur donnerPrivilege(@RequestBody PrivilegeUtilisateur nouvelPrivilege) {
			return privilegeUtilisateurService.save(nouvelPrivilege);
		}
		// delete privilege from user
		@DeleteMapping("/privilege/{id_utlisateur}/{id_privilege}")
		public void supprimerReqeute(@PathVariable(value = "id_utlisateur") Long id_utlisateur,
				@PathVariable(value = "id_privilege") Long id_privilege)
				throws ResourceNotFoundException {
					privilegeUtilisateurService.delete(id_utlisateur,
							id_privilege);
		}
		
		// getAllprivilege  **done**
		@GetMapping("/tousPrivileges")
		public List<Privilege> recupererToutPrivilege() {
			return privilegeService.findAllPrivilege();
		}
 // 
 //	
}
