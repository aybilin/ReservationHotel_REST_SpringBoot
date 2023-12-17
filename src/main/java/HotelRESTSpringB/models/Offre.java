package HotelRESTSpringB.models;

public class Offre {
	private int id;
    private int idHotel;
    private int nombreEtoile;
    private int nombreLit;
    private String nomHotel;
    private int idChambre;
    private int idTypeChambre;
    private int idHotelChambre;
    private int numeroChambre;
    private double prix;
    private String typeChambre;
    private int idAdresse;
    private String quartier;
    private String codePostal;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public int getNombreEtoile() {
		return nombreEtoile;
	}
	public void setNombreEtoile(int nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}
	public int getNombreLit() {
		return nombreLit;
	}
	public void setNombreLit(int nombreLit) {
		this.nombreLit = nombreLit;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public int getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	public int getIdTypeChambre() {
		return idTypeChambre;
	}
	public void setIdTypeChambre(int idTypeChambre) {
		this.idTypeChambre = idTypeChambre;
	}
	public int getIdHotelChambre() {
		return idHotelChambre;
	}
	public void setIdHotelChambre(int idHotelChambre) {
		this.idHotelChambre = idHotelChambre;
	}
	public int getNumeroChambre() {
		return numeroChambre;
	}
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getTypeChambre() {
		return typeChambre;
	}
	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public double getReduction() {
		return reduction;
	}
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	String pays;
    String coordonnees;
    String rue;
    String ville;
    double reduction;
    String disponibilite;
//	static int autoIncrement=200;
//	public int idOffre;
//	public String nomHotel;
//	public int idHotel;
//	public int idChambre;
//	public String numeroAd;
//	public String rueAd;
//	public String lieuDit;
//	public String ville;
//	public String pays;
//	public String positionGps;
//	public int numChambre;
//	public int nombreLit;
//	public int nombreEtoile;
//	public String disponibilite;
//	public Double prixAvecReduction;
    
//    public Long idChambre;
//    public Long idHotel;
//    public String nomHotel;
//    public Long idAdresse;
//    public Integer nombreEtoile;
//    public Long idChambree;
//    public Integer numChambre;
//    public String typeChmabre;
//    public Integer nombreLit;
//    public double prix;
//    public Long idHotele;
//    public Long idAdressee;
//    public String ville;
//    public String pays;
//    public String rueAd;
//    public String numeroAd;
//    public String lieuDit;
//    public String positionGps;
//    public double prixAvecReduction;
//    public String disponibilite;
//	
	

//	public Offre(String nomHotel, int numChambre, String disponibilite, Double prixAvecReduction) {
//		super();
//		this.idOffre = autoIncrement++;
//		this.nomHotel = nomHotel;
//		this.numChambre = numChambre;
//		this.disponibilite = disponibilite;
//		this.prixAvecReduction = prixAvecReduction;
//	}

}
