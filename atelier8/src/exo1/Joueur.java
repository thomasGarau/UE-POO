package exo1;

import java.util.*;

public class Joueur {
	private String nom;
	private String code;
	private static int nbJoueur;
	private int nbPoints;
	private ArrayList<Personnage> listePersonnage = new ArrayList<>();
	private static ArrayList<Personnage> listePersonnageUtilise = new ArrayList<>();
	
	public Joueur(String nom) {
		nbJoueur ++; 
		this.nom = nom;
		this.code = "J" + nbJoueur; 		
	}
	
	public ArrayList<Personnage> getListePersonnage() {
		return listePersonnage;
	}
	
	public String getNom() {
		return nom;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	//ajoute un personnage à la liste des personnages du joueur si celui-ci n'est encore utilisé par aucun joueur.
	public void ajouterPersonnage(Personnage personnage) {
		if(!listePersonnageUtilise.contains(personnage)) {
			this.listePersonnage.add(personnage);
			this.listePersonnageUtilise.add(personnage);
			personnage.setProprietaire(this);
		}
	}
	//modifie le score du joueur
	public void modifierPoint(int valeur) {
		System.out.print(valeur + "\n");
		//le score du joueur ne peut pas être négatif 
		if (this.nbPoints + valeur < 0) {
			this.nbPoints = 0;
		}else {
			this.nbPoints += valeur;
		}
	}
	
	//retourne true si le joueur posséde au moins un personnage
	public boolean peutJouer() {
		return (this.listePersonnage.size() > 0);
	}
	
	//retourne un string représentant le nombre de points et de personnages ainsi que le nom du joueur 
	public String toString() {
		String nbPersonnage;
		if (this.listePersonnage.size() > 0) {
			nbPersonnage = this.listePersonnage.size() + " personnages";
		}else {
			nbPersonnage = "aucun" + "personnage";
		}
		return this.code + " " + this.nom + "(" + this.nbPoints + ")" + " avec " + nbPersonnage;
	}
}
