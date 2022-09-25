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
		Calendar aujourdhui = Calendar.getInstance();
		int anciennete =  aujourdhui.get(Calendar.YEAR) - this.dateEmbauche.get(Calendar.YEAR);
		this.salaire = (int) Math.round(this.salaire * (1 + augmentation / 100 + 0.005 * anciennete));
	}
	
	//remplace la secretaire associé au Manager par une nouvelle passe en param 
	public void changeSecretaire(Secretaire newSecretaire) {
		this.secretaire = newSecretaire;
	}
	
	public String toString(){
		return "\nNom : "+nom+"\n"
		+"Prenom : "+prenom+"\n"+
		"Ne(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
		"-"+dateNaissance.get(Calendar.MONTH)+
		"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
		"Adresse : "+
		adresse.toString() + "\n"+
		salaire +  "\n" +
		secretaire;
	}
}
