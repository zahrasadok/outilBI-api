package com.pfe.bi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.bi.entity.Menu;
import com.pfe.bi.repository.DBmenu;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	public DBmenu i;

	@GetMapping("/{id}")
	public Optional<Menu> getUser(@PathVariable("id") Integer a) {
		System.out.println("id=" + a);
		Optional<Menu> menu = i.findById(a);

		return menu;

	}

	@PostMapping("/save")
	public Menu postUser(@RequestBody Menu menu) {

		System.out.println(menu.getName());

		return i.save(menu);

	}

}
