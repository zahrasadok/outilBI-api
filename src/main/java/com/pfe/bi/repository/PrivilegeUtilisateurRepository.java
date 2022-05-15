package com.pfe.bi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.bi.entity.Privilege;
import com.pfe.bi.entity.PrivilegeUtilisateur;


@Repository
public interface PrivilegeUtilisateurRepository extends
JpaRepository<PrivilegeUtilisateur, Long> {

	//associer la liste des privilige à chaque utilisateurs
	@Query(
			  value = " select p.id, p.description, p.libelle from admin.privilege p "
			  		+ "join admin.acceder pu on pu.id_privilege= p.id "
			  		+ "where pu.id_utilisateur= :id_utilisateur", 
			  nativeQuery = true)
	public List<Privilege> tousPriviligeDUnUtilisateur(@Param("id_utilisateur") Long id_utilisateur);

	//retirer un Privilege d'un Utilisateur
	@Query(
			  value = " delete from admin.acceder "
			  		+ "where id_utilisateur= :id_utilisateur and "
			  		+ "id_privilege= :id_privilege", 
			  nativeQuery = true)
	public Optional<PrivilegeUtilisateur> retirerPrivilegeUtilisateur(Long id_utilisateur, Long id_privilege);

}
