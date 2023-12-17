package HotelRESTSpringB.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomHotel;
    private Integer nombreEtoile;

    @OneToOne// (cascade=jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;

    // Constructeurs, getters et setters

    public Hotel() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Hotel(String nomHotel, Integer nombreEtoile, Adresse adresse) {
        this.nomHotel = nomHotel;
        this.nombreEtoile = nombreEtoile;
        this.adresse = adresse;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public Integer getNombreEtoile() {
        return nombreEtoile;
    }

    public void setNombreEtoile(Integer nombreEtoile) {
        this.nombreEtoile = nombreEtoile;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nomHotel=" + nomHotel + ", nombreEtoile=" + nombreEtoile + ", adresse=" + adresse
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, id, nomHotel, nombreEtoile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(adresse, other.adresse) && id == other.id && Objects.equals(nomHotel, other.nomHotel)
				&& Objects.equals(nombreEtoile, other.nombreEtoile);
	}
    
}
