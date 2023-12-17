package HotelRESTSpringB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import HotelRESTSpringB.models.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
	
	@Query(value="SELECT * FROM Chambre",nativeQuery=true)
	public List<Chambre> chambreAff();

}
