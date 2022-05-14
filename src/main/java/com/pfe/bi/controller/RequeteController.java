package com.pfe.bi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.pfe.bi.entity.Requete;
import com.pfe.bi.repository.RequeteRepository;

@RestController
@RequestMapping("/request")
public class RequeteController {
	
	@Autowired
	private RequeteRepository requeteRepository;
	
	// get requete
	@GetMapping("/requete")
	public List<Requete> recupererToutRequete() {
		return requeteRepository.findAll();
	}

	// get requete byId

	@GetMapping("/requete/{id}")
	public ResponseEntity<Requete> recupererRequete(@PathVariable(name = "id") Long idRequete)

			throws ResourceNotFoundException {
		Requete requeteARechercher = requeteRepository.findById(idRequete)
				.orElseThrow(() -> new ResourceNotFoundException(
						"RequeteController: RequeteController: Requete n'existe pas, id=" + idRequete));
		return ResponseEntity.ok().body(requeteARechercher);
	}

	// save requete (creation)

	@PostMapping("/requete")
	public Requete creerRequete(@RequestBody Requete nouvelleRequete) {
		System.err.println("RequeteController: err"+nouvelleRequete.getId_utilisateur());
		return requeteRepository.save(nouvelleRequete);
	}

	// update requete

	@PutMapping("/requete/{id}")
	public ResponseEntity<Requete> modifierRequete(@PathVariable(value = "id") Long idRequete,
			@Valid @RequestBody Requete RequetepresModification) throws ResourceNotFoundException {
		Requete requeteEnvoyerBD = requeteRepository.findById(idRequete)
				.orElseThrow(() -> new ResourceNotFoundException("RequeteController: Requete n'existe pas, id=" + idRequete));
		requeteEnvoyerBD.setNom(RequetepresModification.getNom());
		requeteEnvoyerBD.setDescription(RequetepresModification.getDescription());
		requeteEnvoyerBD.setType(RequetepresModification.getType());
		requeteEnvoyerBD.setId_utilisteur(RequetepresModification.getId_utilisateur());

		return ResponseEntity.ok(requeteRepository.save(requeteEnvoyerBD));
	}

	// delete requete

	@DeleteMapping("/requete/{id}")
	public Map<String, Boolean> supprimerReqeute(@PathVariable(value = "id") Long idRequete)
			throws ResourceNotFoundException {
		Requete requete = requeteRepository.findById(idRequete)
				.orElseThrow(() -> new ResourceNotFoundException("RequeteController: Requete n'existe pas, id=" + idRequete));
		requeteRepository.delete(requete);

		Map<String, Boolean> reponse = new HashMap<>();
		reponse.put("delete", Boolean.TRUE);

		return reponse;
	}
	
	
	// get requete by nom
	@RequestMapping("/requeteparnom/{nom}")
	public ResponseEntity<Requete> rechercheParNom(@PathVariable(value= "nom") String nom) 		
		throws ResourceNotFoundException {
			Requete requeteRecherche = requeteRepository.rechercheRequeteParNom(nom)
					.orElseThrow(() -> new ResourceNotFoundException("RequeteController: Requete n'existe pas, nom=" + nom));
					
		System.out.println("nom = "+nom);
		return ResponseEntity.ok().body(requeteRecherche);
	}
	
	//get requete by id_utilisateur
	//                                  FAUT MODIFIER POUR RECUPERER UNE LISTEE
	@RequestMapping("/requeteparutil/{id_utilisateur}")
	public ResponseEntity<Requete> rechercheParIdUtilisateur(@PathVariable(value= "id_utilisateur") int id_utilisateur) 		
		throws ResourceNotFoundException {
			Requete requete = requeteRepository.rechercheRequeteParIdUtilisateur(id_utilisateur)
					.orElseThrow(() -> new ResourceNotFoundException("RequeteController: Requete n'existe pas, id_utilisateur=" + id_utilisateur));
					
		System.out.println("RequeteController: id_utilisateur = "+id_utilisateur);
		return ResponseEntity.ok().body(requete);
	}
}