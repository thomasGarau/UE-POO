package attelier7;

import java.util.concurrent.ThreadLocalRandom;

public class DesPiper extends Des {
	private int borne;
	
	public DesPiper(String name, int nb_face, int borne) {
		super(nb_face,name);
		if(borne > nb_face /2 ){
			this.borne = borne;
		}else {
			this.borne = nb_face /2;
		}
		
	}
	
	public int lancer() {
		int a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1);
		while (a < this.borne) {
			a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1);
		}
		return a;
	}
	
	public int lancer(int nb_lancer) {
		int i = 0;
		int a = 0;
		int max = 0;
		while (i < nb_lancer || a < this.borne) {
			a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1);
			if(a > max) {
				max = a;
			}
		i++;
		}
		return max;
	}
}
