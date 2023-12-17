package HotelRESTSpringB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import HotelRESTSpringB.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
