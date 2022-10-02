import java.util.concurrent.ThreadLocalRandom;

public class EntierBarjo extends Entier{
	private int niveauFolie;
	
	
	public EntierBarjo(int borneMin, int borneMax, int valeur, int niveauFolie) {
		super(borneMin, borneMax, valeur);
		this.niveauFolie = niveauFolie;
	}
	
	
	public void incremente() {
		super.incremente();
	}
	
	public void incremente(int valeurIncrementation) {
		int a = ThreadLocalRandom.current().nextInt(0, this.niveauFolie);
		super.incremente(a);
	}
	
}
