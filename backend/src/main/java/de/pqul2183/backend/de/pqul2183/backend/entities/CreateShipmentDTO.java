package de.pqul2183.backend.entities;


import de.pqul2183.backend.entities.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateShipmentDTO {

    private long originCityId;
    private long destinationCityId;
    private String freightType;

}