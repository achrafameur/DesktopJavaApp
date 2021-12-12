package metier.entity;

public class CarnetChèque {
	int id;
	String nom,prenom;
	int nbpages;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNbpages() {
		return nbpages;
	}
	public void setNbpages(int nbpages) {
		this.nbpages = nbpages;
	}
	public CarnetChèque(String nom, String prenom, int nbpages) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nbpages = nbpages;
	}
	public CarnetChèque() {
		super();
	}
	

	

}
