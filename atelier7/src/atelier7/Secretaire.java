package atelier7;

import java.util.*;

public class Secretaire extends Employe{
	private ArrayList<Manager> listeManager = new ArrayList<>(5);
	private static final int NB_MANAGER_MIN = 1;
	private static final int NB_MANAGER_MAX = 5;
	
		
	//verifie que la liste passé en param est inferieur ou egale au nombre Max de manager et supérieur ou egale au nombre min 
	private static boolean essayeListeManager(ArrayList<Manager> listeManager) {
		return (listeManager.size() >= NB_MANAGER_MIN && listeManager.size() <= NB_MANAGER_MAX);
	}
	
	//modifie la listeManager par une liste passer en param si celle-ci est conforme
	public void setListeManager(ArrayList<Manager> listeManager) {
		System.out.print(this.listeManager.size() + "size");
		if(essayeListeManager(listeManager)) {
			this.listeManager = listeManager;
		}
	}

	//constructeur
	private Secretaire(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse, int salaire, GregorianCalendar dateEmbauche, ArrayList<Manager> listeManager) {
		super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
		this.setListeManager(listeManager);
	}
	
	//appel le constructeur si la listeManager est conforme si non retourne null
	public static Secretaire creerSecretaire(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse, int salaire, GregorianCalendar dateEmbauche, ArrayList<Manager> listeManager) {
		if(essayeListeManager(listeManager)){
			return new Secretaire(leNom,lePrenom,laDate,lAdresse,salaire,dateEmbauche,listeManager);
		}else {
			return null;
		}
	}
	
	public ArrayList<Manager> getListeManager() {
		return listeManager;
	}
	
	//parm augmentation => pourcentage de l'augmentation 
	//on ajoute a l'augmentation 0.1 % pour chaque manager associe à la secretaire
	public void augmenterLeSalaire(double augmentation) {
		super.augmenterLeSalaire(augmentation + 0.01 * listeManager.size());
	}
	
	//ajoute le manager passer en param 
	public void ajouteManager(Manager manager) {
		if(listeManager.size() < NB_MANAGER_MAX) {
			this.listeManager.add(manager);
		}
	}
	
	//supprime le manager passer en param
	public void supprimeManager(Manager manager) {
		if(listeManager.size() > NB_MANAGER_MIN) {
			this.listeManager.remove(manager);
		}
	}
	
	public String toString(){
		return super.toString() + "\n" +  listeManager.size();
	}

}
