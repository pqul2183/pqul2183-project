package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.pqul2183.backend.entities.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

}
