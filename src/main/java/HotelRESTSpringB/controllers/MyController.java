package HotelRESTSpringB.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import HotelRESTSpringB.exceptions.EmployeeNotFounfException;
import HotelRESTSpringB.models.Adresse;
import HotelRESTSpringB.models.Chambre;
import HotelRESTSpringB.models.Employee;
import HotelRESTSpringB.models.Hotel;
import HotelRESTSpringB.models.Offre;
import HotelRESTSpringB.models.Reservation;
import HotelRESTSpringB.repositories.AdresseRepository;
import HotelRESTSpringB.repositories.ChambreRepository;
import HotelRESTSpringB.repositories.EmployeeRepository;
import HotelRESTSpringB.repositories.HotelRepository;
import HotelRESTSpringB.repositories.ReservationRepository;

@RestController
public class MyController {
	/*ATTRIBUTES*/
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private HotelRepository repositoryH;
	@Autowired
	private ChambreRepository repositoryC;
	@Autowired
	private AdresseRepository repositoryA;
	@Autowired
	private ReservationRepository repositoryR;
	
	private static final String uri = "service/api";
	
	
	/*METHODES*/
	 
	
	 @GetMapping(uri+"/hotels")
	 public List<Object[]> getHotelsByCriteria(
	 //public Object getHotelsByCriteria(
	            @RequestParam("ville") String ville,
	            @RequestParam("nombreEtoile") int nombreEtoile,
	            @RequestParam("nombreLit") int nombreLit,
	            @RequestParam("idAgence") int idAgence,
	            @RequestParam("prixMin") double prixMin,
	            @RequestParam("prixMax")  double prixMax,
	            @RequestParam("dateEntree")  String dateEntree,
	            @RequestParam("dateSortie")  String dateSortie) {

	        List<Object[]> offres = new ArrayList<>();
	        //String[] offres = null ;

	        try {
	        	offres = repositoryH.findHotelsByCriteria(
	                    ville,
	                    nombreEtoile,
	                    nombreLit,
	                    idAgence,
	                    prixMin,
	                    prixMax,
	                    convertStringToDate(dateEntree),
	                    convertStringToDate(dateSortie)
	            );
	        } catch (Exception e) {
	            e.printStackTrace(); // Gérer l'exception de conversion de date
	        }
	        Object x=offres.get(1)[18];

	        //return x;
	        return offres;
	    }
	 
	 @GetMapping(uri+"/comparator")
	 //public String[] getHotelsByCriteria(
	 public List<Object[]> getComparator(
	            @RequestParam("ville") String ville,
	            @RequestParam("nombreEtoile") int nombreEtoile,
	            @RequestParam("nombreLit") int nombreLit,
	            @RequestParam("prixMin") double prixMin,
	            @RequestParam("prixMax")  double prixMax,
	            @RequestParam("dateEntree")  String dateEntree,
	            @RequestParam("dateSortie")  String dateSortie) {

	        List<Object[]> offres = new ArrayList<>();
	        //String[] offres = null ;

	        try {
	        	offres = repositoryH.Comparator(
	                    ville,
	                    nombreEtoile,
	                    nombreLit,
	                    prixMin,
	                    prixMax,
	                    convertStringToDate(dateEntree),
	                    convertStringToDate(dateSortie)
	            );
	        } catch (Exception e) {
	            e.printStackTrace(); // Gérer l'exception de conversion de date
	        }
	        Object x=offres.get(1)[18];

	        return offres;
	    }


	
	@GetMapping(uri+"/employees")
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	@GetMapping(uri+"/employees/count")
	public String count() {
		return String.format("{\"%s\": %d}", "count", repository.count());
	}
	
	@GetMapping(uri+"/employees/{id}")
	public Employee getEmployeeById(@PathVariable long id) throws EmployeeNotFounfException {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFounfException(
						"error: could not found employee id"+id));
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/reservation")
	public String createReservation(@RequestBody Reservation reservation) {
		//Optional<Hotel> optionalHotel = repositoryH.findById(reservation1.getHotel().getId());
		//Hotel hotel = optionalHotel.orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID")); 
		//repositoryR.save(reservation);
		//System.out.println(hotel);
		//Reservation reservation = new Reservation();
		//reservation1.setHotel(hotel);
		repositoryR.save(reservation);
		return "reservation effectué avec success !";
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	
	@PutMapping(uri+"/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable long id) {
		return repository.findById(id)
				.map(employee -> {
					employee.setName(newEmployee.getName());
					employee.setRole(newEmployee.getRole());
					employee.setEmail(newEmployee.getEmail());
					repository.save(employee);
					return employee;
				})
				.orElseGet(() -> {
					newEmployee.setId(id);
					repository.save(newEmployee);
					return newEmployee;
				});
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri+"/employees/{id}")
	public void deleteEmployee(@PathVariable long id) throws EmployeeNotFounfException {
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFounfException(
						"error: could not found employee id"+id));
		repository.delete(employee);
	}
	@GetMapping(uri+"/tay")
	 public List<Adresse> getadresse(){
		 List<Adresse> adresse= repositoryA.adressAff();
		 return adresse;
	 }
	private java.sql.Date convertStringToDate(String dateString) throws Exception {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date utilDate = format.parse(dateString);
	    return new java.sql.Date(utilDate.getTime());
	}
 
 public static int calculerNombreJoursEntreDates(String dateEntreeStr, String dateSortieStr) throws ParseException, java.text.ParseException {
        // Format de date utilisé (à adapter selon le format de vos dates)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // Conversion des chaînes de caractères en objets Date
        java.util.Date dateEntree = format.parse(dateEntreeStr);
        java.util.Date dateSortie = format.parse(dateSortieStr);

        // Calcul de la différence en millisecondes entre les deux dates
        long differenceEnMillisecondes = dateSortie.getTime() - dateEntree.getTime();

        // Conversion de la différence en jours
        int differenceEnJours = (int) (differenceEnMillisecondes / (24 * 60 * 60 * 1000));

        return differenceEnJours;
    }

}
