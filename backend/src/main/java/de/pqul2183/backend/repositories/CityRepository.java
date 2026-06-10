package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.pqul2183.backend.entities.City;

public interface CityRepository extends JpaRepository<City, Long>  {

}
