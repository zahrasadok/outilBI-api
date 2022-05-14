package com.pfe.bi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.bi.entity.Requete;

@Repository
public interface RequeteRepository extends JpaRepository<Requete, Long>{

	
	@Query(
			  value = "SELECT * FROM requete r WHERE r.nom = :nom", 
			  nativeQuery = true)
		Optional<Requete> rechercheRequeteParNom(@Param("nom") String nom);
	
	@Query(
			  value = "SELECT * FROM requete r WHERE r.id_utilisateur = :id_utilisateur", 
			  nativeQuery = true)
		Optional<Requete> rechercheRequeteParIdUtilisateur(@Param("id_utilisateur") int id_utilisateur);
}