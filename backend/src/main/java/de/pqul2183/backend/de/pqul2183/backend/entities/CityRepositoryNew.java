package de.pqul2183.backend.entities;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepositoryNew extends JpaRepository<City, Long>  {

	
}
