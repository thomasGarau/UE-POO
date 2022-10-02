package attelier7;

import java.util.concurrent.ThreadLocalRandom;

public class DesMemoire extends Des {
	private int dernierLancer;
	
	public DesMemoire(int nbFace, String name) {
		super(nbFace,name);
	}
	
	public int lancer() {
		int lancer = super.lancer();
		while(lancer == this.dernierLancer) {
			lancer = super.lancer(); 
		}
		this.dernierLancer = lancer;
		return lancer;
	}
	
	public int lancer(int nbr_lancer) {
		int lancer = 0;
		int i = 0;
		int max = 0;
		while(i < nbr_lancer || lancer != this.getNb_face()) {
			lancer = this.lancer(); 
			if (lancer > max) {
				max = lancer;
			}
			i++;
		}
		this.dernierLancer = lancer;
		return lancer;
	}
}
