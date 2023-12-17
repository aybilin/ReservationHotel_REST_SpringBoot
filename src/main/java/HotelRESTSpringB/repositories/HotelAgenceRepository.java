package HotelRESTSpringB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import HotelRESTSpringB.models.HotelAgence;

public interface HotelAgenceRepository extends JpaRepository<HotelAgence, Integer> {

}
