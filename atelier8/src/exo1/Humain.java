package exo1;

public class Humain extends Personnage {
	private int nbDeplacement;
	private int niveau =1;
	
	public Humain(String nom, int age) {
		super(nom, age);
	}
	
	//déplace l'hummain et lui augmente sont niveau si sont nombre de déplacement atteint le seuille requis
	public void deplacer(int destination, int gain) {
		super.deplacer(destination, gain);
		if(this.getPosition() == destination) {
			nbDeplacement ++;
			if(nbDeplacement > 3 ) {
				if(nbDeplacement > 5) {
					this.niveau = 3;
				}else {
					this.niveau = 2;
				}
			}
		}
		
	}
	
	//retourne un int représentant la position à laquelle doit être déplacé l'humain
	public int positionSouhaitee() {
		if(this.getPosition() == 0) {
			this.setPosition(1);
		}
		return (this.getPosition() + this.niveau * this.nbDeplacement);
	}
	
	//retourne un string comportant les caractéristique de l'hummain
	public String toString() {
		return "Humain " + super.toString();
	}
}

