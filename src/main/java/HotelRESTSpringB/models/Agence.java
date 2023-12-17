package HotelRESTSpringB.models;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomAgence;

    // Constructeurs, getters et setters

    public Agence() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Agence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id, nomAgence);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agence other = (Agence) obj;
		return id == other.id && Objects.equals(nomAgence, other.nomAgence);
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", nomAgence=" + nomAgence + "]";
	}
    
}
