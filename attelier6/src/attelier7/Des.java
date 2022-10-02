package attelier7;

import java.util.concurrent.ThreadLocalRandom;

public class Des {
	
	private String name;
	public int getNb_face() {
		return nb_face;
	}

	private int nb_face = 6;
	private static int nbrDes = 0;
	private static final int NB_FACE_MAX = 120;
	private static final int NB_FACE_MIN = 3;
			
	public int getNb_faces() {
		return nb_face;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNb_face(int nb_face) {
		if(nb_face < NB_FACE_MIN){
			this.nb_face = NB_FACE_MIN;
		}else if(nb_face >NB_FACE_MAX){
			this.nb_face = NB_FACE_MAX;
		}else {
			this.nb_face = nb_face;
		}
	}
	
	public Des(int nb_face, String name) {
		nbrDes ++;
		this.setNb_face(nb_face);
		if(name != null && name != "" ) {
			this.name = name;
		}else {
			this.name = "Des" + nbrDes;
		}
	}
	
	public Des(int nb_face) {
		this(nb_face, null);
	
	}
	
	public Des() {
		this(6, null);
	}
	
	public int lancer(int nb_lancer) {
		int max = 0;
		int i = 0;
		while( i < nb_lancer && max < this.getNb_face()) {
			int lancer = this.lancer();
			if(lancer > max){
				max = lancer;
			}
			i++;
		}
	return max;
	}
	
	public int lancer() {
		return ThreadLocalRandom.current().nextInt(1, this.nb_face +1);
	}
	
	public boolean equals(Object de) {
		boolean retour = false;
		if(de != null && de instanceof Des) {
			Des de2 =(Des)de;
			retour = (this.name.equals(de2.name) && this.nb_face == de2.nb_face);
		}
		return retour;
	}
	
	public String toString() {
		return "name " + this.name + " nb_faces" + this.nb_face;
	}
	
}
