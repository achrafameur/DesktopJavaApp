package metier.entity;

public class CompteEpargne {
    private int code;
    private double solde;
    private double taux ;
    private String type;
	public CompteEpargne(double solde, double taux, String type) {
		super();
		this.solde = solde;
		this.taux = taux;
		this.type = type;
	}
	public CompteEpargne() {
		super();
	}
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
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

    
}
