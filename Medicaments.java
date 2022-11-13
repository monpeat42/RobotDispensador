package AE1;

public class Medicaments {
	private	int 	cn;
	private String 	marca;
	private String 	nom;
	private double 	preu;
	private int 	unitats;

	public Medicaments(int cn, String marca, String nom, double preu, int unitats) {
		this.cn = cn;
		this.marca = marca;
		this.nom = nom;//medicament
		this.preu = preu;
		this.unitats = unitats;
	}

	public int getCn() {
		return cn;
	}

	public void setCn(int cn) {
		this.cn = cn;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public int getUnitats() {
		return unitats;
	}

	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}
}
