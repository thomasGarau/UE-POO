package exo1;

public class Obstacle {
	private final int penalite;
	
	public Obstacle(int penalite) {
		if(penalite < 1) {
			System.err.print("seule les entier strictement supérieur à 0 sont autoriser");
		}
		this.penalite = penalite;
	}

	public int getPenalite() {
		return penalite;
	}
}
