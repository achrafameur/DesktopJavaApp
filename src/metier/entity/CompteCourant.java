package metier.entity;

public class CompteCourant {
    private int code;
    private double solde;
    private double decouvert;
    private String type;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CompteCourant(double solde, double decouvert, String type) {
		super();
		this.solde = solde;
		this.decouvert = decouvert;
		this.type = type;
	}
	public CompteCourant() {
		super();
	}
    
    
}
