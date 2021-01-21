package com.desafio.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desafio.entities.Locations;
import com.desafio.repositories.LocationsRepository;


@RestController
@RequestMapping("/locations")
public class LocationsResources {

	@Autowired
	private LocationsRepository er;

	public LocationsResources(LocationsRepository er) {
		this.er = er;
	}

	@GetMapping("{id}")
	public Locations getById(@PathVariable long id) {
		return er.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Locations>> findAll(){
		List<Locations> list = er.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Locations save(@RequestBody Locations locations) {
		return er.save(locations);
	}

	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Long id ){
        er.findById(id).map ( locations -> {
                    er.delete(locations);
                    return locations;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "not found") );
        }
	
	@PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Long id, @RequestBody @Valid Locations locations ){
        er.findById(id).map( locationsExistente -> {
                    locations.setId(locationsExistente.getId());
                    er.save(locations);
                    return locationsExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "not found") );
    }

 }
