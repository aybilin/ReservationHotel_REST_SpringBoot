package HotelRESTSpringB.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateArrivee;
    private Date dateDepart;
    private int nombrePersonnes;
    private String nomClient;
    private String prenomClient;
    private String numCarteBancaire;
    private String codeCVC;
    private Date dateExpiration;
    private double prix;

    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "idChambre")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "idAgence")
    private Agence agence;

    // Constructeurs, getters et setters

    public Reservation() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Reservation(
            Date dateArrivee, Date dateDepart, int nombrePersonnes,
            String nomClient, String prenomClient, String numCarteBancaire,
            String codeCVC, Date dateExpiration, double prix,
            Hotel hotel, Chambre chambre, Agence agence) {
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.nombrePersonnes = nombrePersonnes;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.numCarteBancaire = numCarteBancaire;
        this.codeCVC = codeCVC;
        this.dateExpiration = dateExpiration;
        this.prix = prix;
        this.hotel = hotel;
        this.chambre = chambre;
        this.agence = agence;
    }
    //GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getNombrePersonnes() {
		return nombrePersonnes;
	}

	public void setNombrePersonnes(int nombrePersonnes) {
		this.nombrePersonnes = nombrePersonnes;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getNumCarteBancaire() {
		return numCarteBancaire;
	}

	public void setNumCarteBancaire(String numCarteBancaire) {
		this.numCarteBancaire = numCarteBancaire;
	}

	public String getCodeCVC() {
		return codeCVC;
	}

	public void setCodeCVC(String codeCVC) {
		this.codeCVC = codeCVC;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

//	@Override
//	public String toString() {
//		return "Reservation [id=" + id + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart
//				+ ", nombrePersonnes=" + nombrePersonnes + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
//				+ ", numCarteBancaire=" + numCarteBancaire + ", codeCVC=" + codeCVC + ", dateExpiration="
//				+ dateExpiration + ", prix=" + prix + ", hotel=" + hotel + ", chambre=" + chambre + ", agence=" + agence
//				+ "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(agence, chambre, codeCVC, dateArrivee, dateDepart, dateExpiration, hotel, id, nomClient,
//				nombrePersonnes, numCarteBancaire, prenomClient, prix);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Reservation other = (Reservation) obj;
//		return Objects.equals(agence, other.agence) && Objects.equals(chambre, other.chambre)
//				&& Objects.equals(codeCVC, other.codeCVC) && Objects.equals(dateArrivee, other.dateArrivee)
//				&& Objects.equals(dateDepart, other.dateDepart) && Objects.equals(dateExpiration, other.dateExpiration)
//				&& Objects.equals(hotel, other.hotel) && id == other.id && Objects.equals(nomClient, other.nomClient)
//				&& nombrePersonnes == other.nombrePersonnes && Objects.equals(numCarteBancaire, other.numCarteBancaire)
//				&& Objects.equals(prenomClient, other.prenomClient)
//				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
//	}

    
}
