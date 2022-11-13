package AE1;

public class Carrito {
    private String nom, marca;
    private int uni, cn;
    private double preu;

    public Carrito() {}
	public Carrito(int cn, String marca, String nom, int uni, double preu) {
	    this.cn = cn;
	    this.marca = marca;
	    this.nom = nom;
	    this.uni = uni;
	    this.preu = preu;
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
	
	public int getUni() {
	    return uni;
	}
	
	public void setUni(int uni) {
	    this.uni = uni;
	}
	
	public double getPreu() {
	    return preu;
	}
	
	public void setPreu(double preu) {
	    this.preu = preu;
	}
}
