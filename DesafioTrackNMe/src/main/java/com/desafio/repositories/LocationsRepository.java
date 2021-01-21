package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.entities.Locations;


public interface LocationsRepository extends JpaRepository<Locations, Long> {
	  Locations findById(long id);

}