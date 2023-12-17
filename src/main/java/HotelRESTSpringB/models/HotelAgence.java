package HotelRESTSpringB.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HotelAgence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "idAgence")
    private Agence agence;

    private double reduction;

    // Constructeurs, getters et setters

    public HotelAgence() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public HotelAgence(Hotel hotel, Agence agence, double reduction) {
        this.hotel = hotel;
        this.agence = agence;
        this.reduction = reduction;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

	@Override
	public String toString() {
		return "HotelAgence [id=" + id + ", hotel=" + hotel + ", agence=" + agence + ", reduction=" + reduction + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agence, hotel, id, reduction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelAgence other = (HotelAgence) obj;
		return Objects.equals(agence, other.agence) && Objects.equals(hotel, other.hotel) && id == other.id
				&& Double.doubleToLongBits(reduction) == Double.doubleToLongBits(other.reduction);
	}
    
}
