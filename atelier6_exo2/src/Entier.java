
public class Entier {
	private int borneMin;
	private int borneMax;
	private int valeur; 
	
		public Entier(int borneMin, int borneMax, int valeur) {
			if(borneMin <= borneMax) {
				this.borneMin = borneMin;
				this.borneMax = borneMax;
			}
			this.setValeur(valeur);
		}

		public Entier(int borneMin, int borneMax) {
			this(borneMin, borneMax, borneMin);
		}
	
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
	
	public boolean equals(Object entier) {
		if(entier instanceof Entier && entier != null) {
			Entier entier2 = (Entier) entier;
			return(
					this.valeur == entier2.valeur &&
					this.borneMax == entier2.borneMax &&
					this.borneMin == entier2.borneMin
			);
		}else {
			System.err.print("n'est pas un Entier");
			return false;
		}
	}
}
