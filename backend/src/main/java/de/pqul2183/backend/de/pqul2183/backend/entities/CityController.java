package de.pqul2183.backend.entities;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/", produces = "application/json")
@RequiredArgsConstructor
public class CityController {

private final CityRepositoryNew cityRepository;

@GetMapping("/api/cities")
public List<City> getAllCities() {
	return cityRepository.findAll();
}
}