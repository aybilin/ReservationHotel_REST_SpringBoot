package HotelRESTSpringB.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import HotelRESTSpringB.models.Hotel;
import HotelRESTSpringB.models.Offre;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query(value="SELECT DISTINCT C.ID AS idChambre, H.*, C.*, A.*, " +
            "CASE WHEN HA.ID IS NOT NULL THEN C.PRIX * (1 - COALESCE(HA.REDUCTION, 0)) ELSE C.PRIX END AS prixAvecReduction, " +
            "CASE WHEN EXISTS (SELECT 1 FROM Reservation R WHERE C.ID = R.ID_CHAMBRE AND NOT (R.DATE_ARRIVEE > :dateSortie OR R.DATE_DEPART < :dateEntree)) THEN 'indisponible' ELSE 'disponible' END AS disponibilite " +
            "FROM Hotel H " +
            "JOIN Chambre C ON H.ID = C.ID_HOTEL " +
            "JOIN Adresse A ON H.ID_ADRESSE = A.ID " +
            "LEFT JOIN Hotel_Agence HA ON H.ID = HA.ID_HOTEL AND HA.ID_AGENCE = :idAgence " +
            "WHERE A.VILLE = :ville AND H.NOMBRE_ETOILE = :nombreEtoile AND C.NOMBRE_LIT = :nombreLit AND C.PRIX BETWEEN :prixMin AND :prixMax",nativeQuery=true)
    List<Object[]> findHotelsByCriteria(
            @Param("ville") String ville,
            @Param("nombreEtoile") int nombreEtoile,
            @Param("nombreLit") int nombreLit,
            @Param("idAgence") int idAgence,
            @Param("prixMin") double prixMin,
            @Param("prixMax") double prixMax,
            @Param("dateEntree") Date dateEntree,
            @Param("dateSortie") Date dateSortie);
    
    @Query(value = "SELECT DISTINCT C.ID AS idChambre, H.*, C.*, A.*, " +
            "CASE WHEN HA.ID IS NOT NULL THEN C.PRIX * (1 - COALESCE(HA.REDUCTION, 0)) ELSE C.PRIX END AS prixAvecReduction, " +
            "HA.ID_AGENCE AS idAgenceResponsable, " +
            "AG.NOM_AGENCE AS nomAgence, " +
            "CASE WHEN EXISTS (" +
            "    SELECT 1 FROM Reservation R " +
            "    WHERE C.ID = R.ID_CHAMBRE AND NOT (R.DATE_ARRIVEE > :dateSortie OR R.DATE_DEPART < :dateEntree)" +
            ") THEN 'indisponible' ELSE 'disponible' END AS disponibilite " +
            "FROM Hotel H " +
            "JOIN Chambre C ON H.ID = C.ID_HOTEL " +
            "JOIN Adresse A ON H.ID_ADRESSE = A.ID " +
            "LEFT JOIN Hotel_Agence HA ON H.ID = HA.ID_HOTEL " +
            "LEFT JOIN Agence AG ON HA.ID_AGENCE = AG.ID " +
            "WHERE A.VILLE = :ville " +
            "AND H.NOMBRE_ETOILE = :nombreEtoile " +
            "AND C.NOMBRE_LIT = :nombreLit " +
            "AND C.PRIX BETWEEN :prixMin AND :prixMax", nativeQuery = true)
    List<Object[]> Comparator(
            @Param("ville") String ville,
            @Param("nombreEtoile") int nombreEtoile,
            @Param("nombreLit") int nombreLit,
            @Param("prixMin") double prixMin,
            @Param("prixMax") double prixMax,
            @Param("dateEntree") Date dateEntree,
            @Param("dateSortie") Date dateSortie);

}




