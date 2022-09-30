package exo1;

public class JoueurTest {
	
	public static void main(String[] args) {
		
		Humain humain1 = new Humain("Marie", 10);
		Humain humain2 = new Humain("Hercule", 20);
		Humain humain3 = new Humain("Sebastien", 30);
		Humain humain4 = new Humain("clothilde", 40);
		
		Tauren tauren1 = new Tauren("Achile", 2000, 10);
		Tauren tauren2 = new Tauren("Agamemnon", 2000, 7);
		Tauren tauren3 = new Tauren("Leonidas", 2000, 8);
		Tauren tauren4 = new Tauren("Hector", 2000, 4);
		
		Joueur joueur1 = new Joueur("Paul");
		joueur1.ajouterPersonnage(humain1);
		joueur1.ajouterPersonnage(tauren1);
		joueur1.ajouterPersonnage(humain2);
		joueur1.ajouterPersonnage(tauren2);
		
		Joueur joueur2 = new Joueur("Lucien");
		joueur2.ajouterPersonnage(humain3);
		joueur2.ajouterPersonnage(tauren3);
		joueur2.ajouterPersonnage(humain4);
		joueur2.ajouterPersonnage(tauren4);
		
		Jeu partie = new Jeu("AtelierPOO", 20, 10);
		partie.ajouterJoueur(joueur1);
		partie.ajouterJoueur(joueur2);
		
		partie.lancerJeu();
		partie.afficheResultat();

	}
}
