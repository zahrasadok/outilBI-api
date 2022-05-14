package com.pfe.bi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {


		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String name;
		
		public Menu() {
			super();
		}
		
		public Menu(String name) {
			super();
			this.name = name;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}
		
		
	

}
