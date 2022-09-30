package exo1;
import java.util.*;

public class Jeu {
	private String titre;
	private final int NB_MAX_JOUEUR = 6;
	private int nbMaxCase = 50;
	private ArrayList<Joueur> listeJoueur = new ArrayList<>();
	private List<Case> listeCase = new ArrayList<>();
	private int nbEtape;
	private final int nbMaxObstacle;
	private static int scoreMax;
	private Random r = new Random();
	
	public Jeu(String titre, int nbEtape, int nbMaxObstacle) {
		this.titre = titre;
		this.nbEtape = nbEtape;
		this.nbMaxObstacle = nbMaxObstacle;
	}
	
	//ajoute un joueurs à la liste des joueurs si cellui-ci n'y figure pas déjà
	public void ajouterJoueur(Joueur joueur) {
		if(this.listeJoueur.size() > 0) {
			if(!listeJoueur.contains(joueur)) {
				listeJoueur.add(joueur);
			}
		}else {
			this.listeJoueur.add(joueur);
		}
 	}
	
	public List<Case> getListeCase() {
		return listeCase;
	}

	//initialise la liste de tout les personnages participant à la partie 
	public List<Personnage> toutLesPerso() {
		List<Personnage> listPersonnage = new ArrayList<>();
		listeJoueur.forEach(e -> listPersonnage.addAll(e.getListePersonnage()));
		return listPersonnage;
	}
	
	public void initialiserCase(List<Personnage> listPerso) {
		int nbObstacle = 0;
		//creer 15 cases par personnages
		this.nbMaxCase = listPerso.size() * 15;
		for(int i = 0; i < this.nbMaxCase; i++) {
			//génere un nombre aléatoire compris entre 0 inclus et nbMaxCase non inclus
			int a = r.nextInt(this.nbMaxCase);
			//si le nombre aleatoire est modulo de 5 alors ajoute un obstacle sur la case
			if(a%5 == 0 && nbObstacle < this.nbMaxObstacle) {
				Obstacle obs = new Obstacle(a*2);
				Case case1 = new Case(obs);
				this.listeCase.add(case1);
				nbObstacle ++;
			}else {
				Case case1 = new Case(a);
				this.listeCase.add(case1);
			}
		}
	}
	
	//rend aléatoire la position de chaque case dans listeCase
	public void renversePlateau() {
		int a = nbMaxCase;
		//liste temporaire
		List<Case> listeCasee = new ArrayList<>();
		for(int i =0; i<this.nbMaxCase;i++ ) {
			//génére nombre aléatoire entre 0 et nbMaxCase non inclus
			int r =(int)(Math.random() * a);
			listeCasee.add(this.listeCase.get(r));
			//retire 1 à a pour évité de générer des nombre aléatoire suppérieur à la taille de la liste
			this.listeCase.remove(r);
			a -=1;
		}
		this.listeCase = listeCasee;
	}
	
	//execute la partie
	public void lancerJeu() {
		boolean placer = false;
		List<Personnage>listPerso = toutLesPerso();
		this.initialiserCase(listPerso);
		int i = 0;
		//place tout les personnages sur les premières case du plateau ne possédant pas d'obstacle (1seule perso par case)
		for(int j=0; j < listPerso.size(); j++) {
			placer = false;
			while(!placer) {
				if(this.listeCase.get(i).estVide()) {
					this.listeCase.get(i).setPerso(listPerso.get(j));
					listPerso.get(j).setPosition(i);
					placer = true;
				}
				i++;
			}
		}
		this.renversePlateau();
		this.afficherCases();
		for(int i2 = 0; i2 < this.nbEtape; i2++) {
			for(int j2 = 0; j2 < listPerso.size(); j2++) {
				int position = listPerso.get(j2).positionSouhaitee() %this.listeCase.size();
				//si la case comporte un obstacle applique la pénalité 
				if(!this.listeCase.get(position).sansObstacle()) {
					listPerso.get(j2).getProprietaire().modifierPoint(-listeCase.get(position).getObs().getPenalite());
				// si la case comporte un personnage applique la pénalité
				}else if(!this.listeCase.get(position).sansPerso()) {
					listPerso.get(j2).getProprietaire().modifierPoint(-listeCase.get(position).getGain());
					// si non déplace le personnage à la position souhaiter et applique le gain au joueur
				}else {
					this.listeCase.get(position).setPerso(listPerso.get(j2));
					this.listeCase.get(listPerso.get(j2).getPosition()).setPerso(null);
					listPerso.get(j2).deplacer(position, this.listeCase.get(position).getGain());
				}
			}
		}
	}
		
		//Affiche chaques cases de listeCase en console avec leurs gain/pénalité et la préssence d'obstacles ou de joueurs sur celle-ci. 
		public void afficherCases() {
			String retour = "";
			for(int i =0; i < this.listeCase.size(); i++) {
				Case caze = this.listeCase.get(i);
				if(!caze.sansObstacle()) {
					retour = "Obstacle (penalite = -" + caze.getObs().getPenalite() + ") \n";
				}else if(!caze.sansPerso()) {
					Personnage perso  = caze.getPerso();
					retour = perso.getClass() + " " + perso.getNom() + "(penalite = -" + caze.getGain() + ") \n";
				}else {
					retour = "Libre (gain = " + caze.getGain() + ") \n"; 
				}
			System.out.print(retour);
			}
		}
		
		//affiche la liste des joueurs ainsi que leurs score actuelle
		public void afficherParticipant() {
			String retour = " LSITE DES JOUEURS \n" ;
			for(int i = 0; i < this.listeJoueur.size();i++) {
				retour += "----------------------------------------------------------------- \n" +
						"J" + i + " " +
						this.listeJoueur.get(i).getNom() +
						" (" + this.listeJoueur.get(i).getNbPoints() +
						"points) avec " + 
						this.listeJoueur.get(i).getListePersonnage().size() +
						" personnages \n";
			}
			System.out.print(retour);
		}
		
		//retourne le joueur ayant obtenu le socre maximum de la partie 
		public Joueur joueurMaxScore() {
			Joueur joueurMax = null;
			int maximum = 0;
			for(int i = 0; i < this.listeJoueur.size(); i++) {
				if(listeJoueur.get(i).getNbPoints() > maximum) {
					maximum = this.listeJoueur.get(i).getNbPoints();
					joueurMax = this.listeJoueur.get(i);
				}
			}
			return joueurMax;
		}
		
		//affiche les score de chaques joueurs et annonce le vainqueur
		public void afficheResultat() {
			Joueur gagnant = this.joueurMaxScore();
			if(gagnant != null) {
				String retour = "RESULTATS \n Le gagnant est " + gagnant.getNom() + " avec " + gagnant.getNbPoints() + " points \n";
				if(gagnant.getNbPoints() > scoreMax) {
					retour += "Record battu : Ancien score maximum " + scoreMax;
					scoreMax = gagnant.getNbPoints();
				}else {
					retour += "Reccord " + scoreMax;
				}
				System.out.print(retour);
				afficherParticipant();
			}else {
				System.err.print("aucun vainqueur");
			}
		}
}
