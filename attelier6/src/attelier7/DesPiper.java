package attelier7;

import java.util.concurrent.ThreadLocalRandom;

public class DesPiper extends Des {
	private final int BORNE;
	
	public DesPiper(String name, int getNb_faces, int BORNE) {
		super(getNb_faces,name);
		if(BORNE > getNb_faces /2 ){
			this.BORNE = BORNE;
		}else {
			this.BORNE = getNb_faces /2;
		}
		
	}
	
	public int lancer() {
		int lancer = super.lancer();
		while (lancer < this.BORNE) {
			lancer = super.lancer();
		}
		return lancer;
	}
	
	public int lancer(int nb_lancer) {
		int i = 0;
		int lancer = 0;
		int max = 0;
		while (i < nb_lancer || lancer < this.BORNE) {
			lancer = this.lancer();
			if(lancer > max) {
				max = lancer;
			}
		i++;
		}
		return max;
	}
}
