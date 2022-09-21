
public class Entier {
	protected int borneMin;
	protected int borneMax;
	protected int valeur; 
	
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		if (valeur >= this.borneMin && valeur <= this.borneMax) {
			this.valeur = valeur;
		}
	}
	public int getBorneMin() {
		return borneMin;
	}
	public int getBorneMax() {
		return borneMax;
	}
	
	
	public Entier(int borneMin, int borneMax) {
		if(borneMin <= borneMax) {
			this.borneMin = borneMin;
			this.borneMax = borneMax;
		}
	}
	
	public Entier(int borneMin, int borneMax, int valeur) {
		if(borneMin <= borneMax) {
			this.borneMin = borneMin;
			this.borneMax = borneMax;
		}
		this.setValeur(valeur);
	}
	
	public void incremente() {
		this.incremente(1);
	}
	
	public void incremente(int valeurIncrementation) {
		if(this.valeur + valeurIncrementation <= this.borneMax) {
			this.valeur += valeurIncrementation;
		}
	}
	
	public String toString() {
		return "valeur " + this.valeur + " borneMin " +
		this.borneMin + " borneMax " + this.borneMax;
	}
	
	public boolean equals(Entier entier) {
		return(
				this.valeur == entier.valeur &&
				this.borneMax == entier.borneMax &&
				this.borneMin == entier.borneMin
		);
	}
}