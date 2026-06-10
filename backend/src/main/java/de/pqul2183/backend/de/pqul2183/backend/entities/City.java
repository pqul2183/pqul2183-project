package de.pqul2183.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="City")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long UUID;
	
	
	private String name;
	
	
	private String country;
	
	
}
