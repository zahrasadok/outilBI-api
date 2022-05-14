package com.pfe.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.bi.entity.Menu;

//@Repository
public interface DBmenu extends JpaRepository<Menu, Integer> {

}
