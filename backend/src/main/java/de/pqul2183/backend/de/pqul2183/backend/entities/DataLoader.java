package de.pqul2183.backend.entities;


import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
	@Autowired
	CityRepositoryNew cityRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<City> cities = cityRepository.findAll(); 
		List<City> newCities = List.of(
				City.builder().name("Berlin").country("Germany").build(),
				City.builder().name("Amsterdam").country("Netherlands").build(),
				City.builder().name("Los Angeles").country("USA").build(),
				City.builder().name("Istanbul").country("Turkey").build(),
				City.builder().name("New York").country("USA").build(),
				City.builder().name("Vienna").country("Austria").build(),
				City.builder().name("Kempten").country("Germany").build(),
				City.builder().name("Paris").country("France").build()
				 );
				
		if (cities.isEmpty()) {
            cityRepository.saveAll(newCities);
	
	
		}


	
}

}
	
	
	

