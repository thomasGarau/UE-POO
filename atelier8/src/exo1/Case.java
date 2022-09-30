package exo1;

public class Case {
	private int gain;
	private Personnage perso = null;
	private Obstacle obs;
	
	public Case(Obstacle obs) {
		this.obs =  obs;
	}
	
	public Case(int gain) {
		this.gain =  gain;
	}
	
	public Personnage getPerso() {
		return perso;
	}
	
	public void setPerso(Personnage perso) {
		this.perso = perso;
	}

	public Obstacle getObs() {
		return obs;
	}

	public int getGain() {
		return gain;
	}
	
	public int getPenalite() {
		int retour = 0;
		if(obs != null) {
			retour = obs.getPenalite();
		}
		return retour;
	}
	
	public void placerPersonnage(Personnage perso) {
		if(perso != null) {
			this.perso = perso;
		}
	}
	
	public void placerObstacle(Obstacle obs) {
		if(obs != null) {
			this.obs = obs;
		}
	}
	
	public void enleverPersonnage() {
		this.perso = null;
	}
	
	public boolean sansObstacle() {
		return (this.obs == null);
	}
	
	public boolean sansPerso() {
		return (this.perso == null);
	}
	
	public boolean estVide() {
		return (this.sansObstacle() && this.sansPerso());
	}
	
	public String toString() {
		String retour = "";
		if(!this.sansObstacle()) {
			retour += "Obstacle (penalité = -" + this.gain + ")";
		}else if(this.sansPerso()){
			retour += this.perso + " " + this.perso.getNom() + " (penalité = -" + this.obs.getPenalite()	+ ")";
		}else {
			retour = "Libre (gain = " +this.gain + ")";
		}
		return retour;
	}
	
}
