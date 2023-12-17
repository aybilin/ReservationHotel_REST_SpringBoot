package HotelRESTSpringB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import HotelRESTSpringB.models.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
	@Query(value="SELECT * FROM Adresse",nativeQuery=true)
	public List<Adresse> adressAff();

}
