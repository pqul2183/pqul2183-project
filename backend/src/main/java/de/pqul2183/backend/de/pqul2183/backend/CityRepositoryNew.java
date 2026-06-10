package de.pqul2183.backend;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.pqul2183.backend.entities.City;


@Repository
public interface CityRepositoryNew extends JpaRepository<City, Long>  {

	
}
