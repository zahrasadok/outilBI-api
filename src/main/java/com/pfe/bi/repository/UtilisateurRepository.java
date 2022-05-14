package com.pfe.bi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.bi.entity.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	// verifier les parametres de connexion d'un utilisateur (nom_utilisateur et mot de passe)
	@Query(
			  value = "SELECT * FROM admin.utilisateur u WHERE u.nom_utilisateur = :nom_utilisateur"
			  		+ " and u.mdps= :mdps", 
			  nativeQuery = true)
		Utilisateur connexionUtilisateur(@Param("nom_utilisateur") String nom_utilisateur
				,@Param("mdps") String mdps );
}
