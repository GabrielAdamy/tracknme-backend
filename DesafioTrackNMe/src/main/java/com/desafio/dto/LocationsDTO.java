package com.desafio.dto;

import com.desafio.entities.Locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationsDTO {
    private long id;
    private Integer trackerId;
    private String dateTime;
    private Double latitude;
    private Double longitude;

    
    public LocationsDTO(Locations entity) {
        this.id = entity.getId();
        this.trackerId = entity.getTrackerId();
        this.dateTime = entity.getDateTime();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
    }

 }

