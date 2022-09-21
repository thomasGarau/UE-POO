package attelier7;

import java.util.concurrent.ThreadLocalRandom;

public class Des {
	
	protected String name;
	protected int nb_face = 6;
	protected static int nbrDes = 0;
	protected static final int nb_face_max = 120;
	protected static final int nb_face_min = 3;
	
	public int getNb_faces() {
		return nb_face;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNb_face(int nb_face, int nb_face_max, int nb_face_min) {
		if(nb_face < nb_face_min){
			this.nb_face = nb_face_min;
		}else if(nb_face >nb_face_max){
			this.nb_face = nb_face_max;
		}else {
			this.nb_face = nb_face;
		}
	}
	
	public Des(int nb_face, String name) {
		nbrDes ++;
		this.setNb_face(nb_face, nb_face_max, nb_face_min);
		if(name != null && name != "" ) {
			this.name = name;
		}else {
			this.name = "Des" + nbrDes;
		}
	}
	
	public Des(int nb_face) {
		this(nb_face, ("Des" + nbrDes));
	
	}
	
	public Des() {
		this(6, ("Des" + nbrDes));
	}
	
	public int lancer(int nb_lancer) {
		int max = 0;
		for(int i=0; i < nb_lancer; i++) {
			int a = ThreadLocalRandom.current().nextInt(1, this.nb_face +1);
			if(a > max){
				max = 0;
			}
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
			retour = (this.name == de2.name && this.nb_face == de2.nb_face);
		}
		return retour;
	}
	
	public String toString() {
		return "name " + this.name + " nb_faces" + this.nb_face;
	}
	
}