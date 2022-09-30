package atelier7;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Manager extends Employe {
	private Secretaire secretaire;
	
	public Manager(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse, int salaire, GregorianCalendar dateEmbauche, Secretaire secretaire) {
		super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
		this.secretaire = secretaire;
	}
	public Manager(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse, int salaire, GregorianCalendar dateEmbauche) {
		super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
	}
	
	
	//parm augmentation => pourcentage de l'augmentation 
	//ajoute une augmentation de 0.5% par annees d'anciennetes 
	public void augmenterLeSalaire(double augmentation) {
		super.augmenterLeSalaire(augmentation + 0.5 * this.calculAnnuite() );
	}
	
	//remplace la secretaire associé au Manager par une nouvelle passe en param 
	public void changeSecretaire(Secretaire newSecretaire) {
		this.secretaire = newSecretaire;
	}
	
	public String toString(){
		return super.toString() + "\n" + this.secretaire;
	}
}
