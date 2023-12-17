package HotelRESTSpringB.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pays;
    private String ville;
    private String rue;
    private String numero;
    private String lieuDit;
    private String positionGps;

    // Constructeurs, getters et setters

    public Adresse() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Adresse(String pays, String ville, String rue, String numero, String lieuDit, String positionGps) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        this.lieuDit = lieuDit;
        this.positionGps = positionGps;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLieuDit() {
        return lieuDit;
    }

    public void setLieuDit(String lieuDit) {
        this.lieuDit = lieuDit;
    }

    public String getPositionGps() {
        return positionGps;
    }

    public void setPositionGps(String positionGps) {
        this.positionGps = positionGps;
    }

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", pays=" + pays + ", ville=" + ville + ", rue=" + rue + ", numero=" + numero
				+ ", lieuDit=" + lieuDit + ", positionGps=" + positionGps + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lieuDit, numero, pays, positionGps, rue, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return id == other.id && Objects.equals(lieuDit, other.lieuDit) && Objects.equals(numero, other.numero)
				&& Objects.equals(pays, other.pays) && Objects.equals(positionGps, other.positionGps)
				&& Objects.equals(rue, other.rue) && Objects.equals(ville, other.ville);
	}
    
}

