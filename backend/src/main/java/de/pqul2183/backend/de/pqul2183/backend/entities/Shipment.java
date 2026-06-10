package de.pqul2183.backend.entities;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="Shipment")
public class Shipment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "origin_city_id")
	private City originCity;
	
	@ManyToOne
	@JoinColumn(name="destination_city_id")
	private City destinationCity;
	
	private FreightType freightType;
	
	private String estimatedDays;
	
	@CreationTimestamp
	private Instant createdAt;
	
	private ShipmentStatus status;
}
