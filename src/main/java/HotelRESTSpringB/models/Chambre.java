package HotelRESTSpringB.models;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer numChambre;
    private String type;
    private Integer nombreLit;
    private Double prix;
    private String image;
    

    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;

    // Constructeurs, getters et setters

    public Chambre() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Chambre(Integer numChambre, String type, Integer nombreLit, Double prix,String image, Hotel hotel) {
        this.numChambre = numChambre;
        this.type = type;
        this.nombreLit = nombreLit;
        this.prix = prix;
        this.image=image;
        this.hotel = hotel;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(Integer numChambre) {
        this.numChambre = numChambre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNombreLit() {
        return nombreLit;
    }

    public void setNombreLit(Integer nombreLit) {
        this.nombreLit = nombreLit;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Chambre [id=" + id + ", numChambre=" + numChambre + ", type=" + type + ", nombreLit=" + nombreLit
				+ ", prix=" + prix + ", hotel=" + hotel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hotel, id, nombreLit, numChambre, prix, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chambre other = (Chambre) obj;
		return Objects.equals(hotel, other.hotel) && id == other.id && Objects.equals(nombreLit, other.nombreLit)
				&& Objects.equals(numChambre, other.numChambre) && Objects.equals(prix, other.prix)
				&& Objects.equals(type, other.type);
	}
    
}
