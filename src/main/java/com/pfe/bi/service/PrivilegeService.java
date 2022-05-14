package com.pfe.bi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.bi.entity.Privilege;
import com.pfe.bi.repository.PrivilegeRepository;

@Service
public class PrivilegeService {
	
	@Autowired
	PrivilegeRepository privilegeRepository;

	public Privilege save(Privilege nouveauPrivilege) {
		
		return privilegeRepository.save(nouveauPrivilege);
	}

	public List<Privilege> findAllPrivilege() {
		return privilegeRepository.findAll();
	}

}
