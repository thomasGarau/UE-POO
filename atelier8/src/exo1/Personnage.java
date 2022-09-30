package exo1;

	public abstract class Personnage {
	private String nom;
	private int age;
	private int position; 
	private Joueur proprietaire;
	
	public Personnage(String nom, int age) {
		this.nom = nom;
		this.age = age; 
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getNom() {
		return nom;
	}

	//déplace le personnage à la destination souhaité et modifie le score du joueur possédant le personnage
	public void deplacer(int destination, int gain) {
		this.position = destination;
		proprietaire.modifierPoint(gain);
	}
	
	//applique la penalité recu par le personnage à sont propriétaire
	public void penaliser(int penalite) {
		proprietaire.modifierPoint(penalite);
	}
	
	//retourne le nom du personnage
	public String toString() {
		return this.nom;
	}
	
	public abstract int positionSouhaitee();
}
