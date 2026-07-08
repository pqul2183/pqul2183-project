package de.pqul2183.backend.entities;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.pqul2183.backend.entities.CreateShipmentDTO;
import de.pqul2183.backend.*;
import lombok.RequiredArgsConstructor;
import de.pqul2183.backend.entities.CityRepositoryNew;

@RestController
@RequestMapping(value = "/api/shipments", produces = "application/json")
@RequiredArgsConstructor
public class ShipmentController {

    private final CityRepositoryNew CityRepository;

    private final ShipmentRepository shipmentRepository;

    private final DeliveryTimeService deliveryTimeService;

    @GetMapping
    List<Shipment> getShipments() {
        return shipmentRepository.findAll();
    }

    @PostMapping
    ResponseEntity<Shipment> createShipment(@RequestBody CreateShipmentDTO createShipmentDto) {

        // check if origin and destination are the same
        if(createShipmentDto.getOriginCityId() == createShipmentDto.getDestinationCityId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Optional<FreightType> freightType = Optional.empty();

        Optional<City> originCity = CityRepository.findById(createShipmentDto.getOriginCityId());
        Optional<City> destinationCity = CityRepository.findById(createShipmentDto.getDestinationCityId());

        if(createShipmentDto.getFreightType().equals("AIR")) {
            freightType = Optional.of(FreightType.AIR);
        }

        if(createShipmentDto.getFreightType().equals("SEA")) {
            freightType = Optional.of(FreightType.SEA);
        }

        if (originCity.isPresent() && destinationCity.isPresent() && freightType.isPresent()) {

            int calculatedDeliveryTimeInDays = deliveryTimeService.calculateDays(originCity.get(), destinationCity.get(), freightType.get());

            Shipment shipment = shipmentRepository.save(Shipment.builder()
                    .originCity(originCity.get())
                    .destinationCity(destinationCity.get())
                    .freightType(freightType.get())
                    .estimatedDays(String.valueOf(calculatedDeliveryTimeInDays))
                    .status(ShipmentStatus.IN_PROGRESS)
                    .build());
           
            return ResponseEntity.status(HttpStatus.CREATED).body(shipment);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}