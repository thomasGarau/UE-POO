package attelier7;

import java.util.concurrent.ThreadLocalRandom;

public class DesMemoire extends Des {
	private int dernierLancer;
	
	public DesMemoire(int nb_face, String name) {
		super(nb_face,name);
	}
	
	public int lancer() {
		int a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1);
		while(a == this.dernierLancer) {
			a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1); 
		}
		this.dernierLancer = a;
		return a;
	}
	
	public int lancer(int nbr_lancer) {
		int a = 0;
		int i = 0;
		int max = 0;
		while(i < nbr_lancer || a == this.dernierLancer) {
			a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1); 
			if (a > max) {
				max = a;
			}
			i++;
		}
		this.dernierLancer = a;
		return a;
	}
}
