package exo1;

import java.util.*;

public class Tauren extends Personnage{
	private int taille;
	
	public Tauren(String nom, int age, int taille) {
		super(nom, age);
		this.taille = taille;
	}
	
	//retourne un int compris entre 0 et la taille du tauren représentant la position à laquelle il doit être déplacé
	public int positionSouhaitee() {
		int r =this.getPosition() + (int)(Math.random() * taille) +1;
		return r;
	}
	
	//retourne les information du tauren
	public String toString() {
		return "Tauren " +  super.toString();
	}
}
