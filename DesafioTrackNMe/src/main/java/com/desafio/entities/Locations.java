package com.desafio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "tb_location")
public class Locations {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private long id;

	    @Column(name = "trackerId")
	    private Integer  trackerId;

	    @Column(name = "dateTime")
	    private String dateTime;

	    @Column(name = "latitude")
	    private Double latitude;

	    @Column(name = "longitude")
	    private Double longitude;
	    
	    public Locations() {}

	    public Locations(long id, Integer trackerId, String dateTime, Double latitude, Double longitude) {
	        this.id = id;
	        this.trackerId = trackerId;
	        this.dateTime = dateTime;
	        this.latitude = latitude;
	        this.longitude = longitude;

	    }
	}
