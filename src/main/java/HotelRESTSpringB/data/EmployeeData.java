package HotelRESTSpringB.data;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import HotelRESTSpringB.models.Adresse;
import HotelRESTSpringB.models.Agence;
import HotelRESTSpringB.models.Chambre;
import HotelRESTSpringB.models.Employee;
import HotelRESTSpringB.models.Hotel;
import HotelRESTSpringB.models.HotelAgence;
import HotelRESTSpringB.models.Reservation;
import HotelRESTSpringB.repositories.AdresseRepository;
import HotelRESTSpringB.repositories.AgenceRepository;
import HotelRESTSpringB.repositories.ChambreRepository;
import HotelRESTSpringB.repositories.EmployeeRepository;
import HotelRESTSpringB.repositories.HotelAgenceRepository;
import HotelRESTSpringB.repositories.HotelRepository;
import HotelRESTSpringB.repositories.ReservationRepository;
@Configuration
public class EmployeeData {
	/*ATTRIBUTES*/
	private Logger logger = LoggerFactory.getLogger(EmployeeData.class);
	
	@Bean
	public CommandLineRunner initDatabase(
	        HotelRepository repositoryH,
	        AdresseRepository repositoryA,
	        ChambreRepository repositoryC,
	        AgenceRepository repositoryAG,
	        HotelAgenceRepository repositoryHA,
	        ReservationRepository repositoryR) {
	    return args -> {
	        logger.info("Connect success");

	        // Ajouter une adresse
	        Adresse adresse1 = repositoryA.save(
	                new Adresse("France", "Paris", "Rue de la Paix", "123", "Quartier chic", "48.8566° N, 2.3522° E"));
	        Adresse adresse2 = repositoryA.save(
	                new Adresse("Espagne", "Barcelone", "Rue de la Paix", "123", "Quartier chic", "48.8566° N, 2.3522° E"));
	        Adresse adresse3 = repositoryA.save(
	                new Adresse("Espagne", "Barcelone", "Rue de la jorke", "25", "Quartier Messi", "25.8566° N, 78.3522° E"));
	        Adresse adresse4 = repositoryA.save(
	                new Adresse("Italie", "Rome", "Rue de pize", "123", "Quartier chic", "48.8566° N, 2.3522° E"));

	        // Ajouter un hôtel avec l'adresse précédemment créée
	        Hotel hotel1 = repositoryH.save(
	                new Hotel("Grand Hotel", 4, adresse2));
	        Hotel hotel2 = repositoryH.save(
	                new Hotel("IBIS Hotel", 4, adresse3));
	        Hotel hotel3 = repositoryH.save(
	                new Hotel("Roma Hotel", 4, adresse4));
	        Hotel hotel4 = repositoryH.save(
	                new Hotel("Paris Hotel", 4, adresse1));

	        // Ajouter une chambre pour l'hôtel
	        Chambre chambre1 = repositoryC.save(
	                new Chambre(101, "Suite", 2, 200.0,"https://businessblog.trivago.com/wp-content/uploads/2016/04/MainArticle.jpg", hotel1));
	        Chambre chambre2 = repositoryC.save(
	                new Chambre(102, "Suite", 2, 200.0,"https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", hotel1));
	        Chambre chambre3 = repositoryC.save(
	                new Chambre(103, "Suite", 2, 200.0,"https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", hotel1));
	        Chambre chambre4 = repositoryC.save(
	                new Chambre(104, "Suite", 2, 200.0,"https://businessblog.trivago.com/wp-content/uploads/2016/04/MainArticle.jpg", hotel1));
	        Chambre chambre5 = repositoryC.save(
	                new Chambre(105, "Suite", 2, 200.0,"https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", hotel2));
	        Chambre chambre6 = repositoryC.save(
	                new Chambre(106, "Suite", 2, 200.0,"https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", hotel3));
	        Chambre chambre7 = repositoryC.save(
	                new Chambre(107, "Suite", 2, 200.0,"https://businessblog.trivago.com/wp-content/uploads/2016/04/MainArticle.jpg", hotel3));
	        Chambre chambre8 = repositoryC.save(
	                new Chambre(108, "Suite", 2, 200.0,"https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", hotel4));
	        Chambre chambre9 = repositoryC.save(
	                new Chambre(109, "Suite", 2, 200.0,"https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", hotel4));

	        // Ajouter une agence
	        Agence agence1 = repositoryAG.save(
	                new Agence("Agence de Voyage SPA1"));
	        Agence agence2 = repositoryAG.save(
	                new Agence("Agence de Voyage SPA2"));
	        Agence agence3 = repositoryAG.save(
	                new Agence("Agence de Voyage SPA3"));
	        Agence agence4 = repositoryAG.save(
	                new Agence("Agence de Voyage SPA4"));

	        // Associer l'hôtel et l'agence avec une réduction
	        HotelAgence hotelAgence1 = repositoryHA.save(
	                new HotelAgence(hotel1, agence1, 0.1)); // Réduction de 10%
	        HotelAgence hotelAgence4 = repositoryHA.save(
	                new HotelAgence(hotel1, agence2, 0.2)); // Réduction de 20%
	        HotelAgence hotelAgence2 = repositoryHA.save(
	                new HotelAgence(hotel1, agence3, 0.3)); // Réduction de 30%
	        HotelAgence hotelAgence3 = repositoryHA.save(
	                new HotelAgence(hotel1, agence4, 0.4)); // Réduction de 40%
	        // Ajouter une réservation
	        Reservation reservation = repositoryR.save(
	                new Reservation(
	                		convertStringToDate("2023-12-02"), convertStringToDate("2023-12-12"), 2,
	                        "Doe", "John", "1234567890123456",
	                        "123", convertStringToDate("2028-12-02"), 180.0,
	                        hotel1, chambre1, agence1));

	        // Vous pouvez ajouter d'autres données selon vos besoins

	        logger.info("Database preloaded successfully");
	    };
	}
	private java.sql.Date convertStringToDate(String dateString) throws Exception {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date utilDate = format.parse(dateString);
	    return new java.sql.Date(utilDate.getTime());
	}

	
//	@Bean
//	public CommandLineRunner initDatabase(HotelRepository repositoryH,AdresseRepository repositoryA,
//			ChambreRepository repositoryC,AgenceRepository repositoryAG,HotelAgenceRepository repositoryHA) {
//		return args ->{
//			logger.info("connect sucsess ");
//			logger.info("Preloading database with "+ repositoryH.save(
//					new Hotel("Grand Hotel",4,new Adresse())));
//			logger.info("Preloading database with "+ repositoryA.save(
//					new Adresse()));
//			logger.info("Preloading database with "+ repositoryC.save(
//					new Chambre()));
//			logger.info("Preloading database with "+ repositoryAG.save(
//					new Agence()));
//			logger.info("Preloading database with "+ repositoryHA.save(
//					new HotelAgence()));
//		};
//		};
	}
//	public CommandLineRunner initDatabase(AdresseRepository repositoryA) {
//		return args ->{
//			logger.info("connect sucsess ");
//			logger.info("Preloading database with "+ repositoryA.save(
//					new Adresse()));
//		};
//	}
//	public CommandLineRunner initDatabase(ChambreRepository repositoryC) {
//		return args ->{
//			logger.info("connect sucsess ");
//			logger.info("Preloading database with "+ repositoryC.save(
//					new Chambre()));
//		};
//	}
//	public CommandLineRunner initDatabase(AgenceRepository repositoryAG) {
//		return args ->{
//			logger.info("connect sucsess ");
//			logger.info("Preloading database with "+ repositoryAG.save(
//					new Agence()));
//		};
//	}
//	public CommandLineRunner initDatabase(AgenceRepository repositoryHA) {
//		return args ->{
//			logger.info("connect sucsess ");
//			logger.info("Preloading database with "+ repositoryHA.save(
//					new HotelAgence()));
//		};
	


