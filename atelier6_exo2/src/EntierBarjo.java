import java.util.concurrent.ThreadLocalRandom;

public class EntierBarjo extends Entier{
	private int niveauFolie;
	
	
	public EntierBarjo(int borneMin, int borneMax, int valeur, int niveauFolie) {
		super(borneMin, borneMax, valeur);
		this.setValeur(valeur);
		this.niveauFolie = niveauFolie;
	}
	
	
	public void incremente() {
		int a = ThreadLocalRandom.current().nextInt(0, this.niveauFolie);
		if(this.valeur + a < this.borneMax) {
			this.valeur += a+1;
		}
	}
	
	public void incremente(int valeurIncrementation) {
		int a = ThreadLocalRandom.current().nextInt(0, this.niveauFolie);
		if(this.valeur + valeurIncrementation + a <= this.borneMax) {
			this.valeur += valeurIncrementation + a;
		}
	}
	
}
