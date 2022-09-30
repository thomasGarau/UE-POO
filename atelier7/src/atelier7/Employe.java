package atelier7;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;
import atelier7.Adresse;


public class Employe extends Personne{
	private int salaire;
	private final GregorianCalendar DATE_EMBAUCHE;
	private final static int AGE_MIN_LEGALE = 16;
	private final static int AGE_MAX_LEGALE = 65;

	
	protected Employe(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse, int salaire, GregorianCalendar DATE_EMBAUCHE) {
		super(leNom, lePrenom, laDate, lAdresse);
		this.salaire = salaire;
		this.DATE_EMBAUCHE = DATE_EMBAUCHE;
	}
	
	public GregorianCalendar getDATE_EMBAUCHE() {
		return DATE_EMBAUCHE;
	}

	// attention les mois de  gregorianCalendar commence à 0 
	// prend en param les arguments nécessaires aux constructeur et 
	//l'appel uniquement si l'age de l'employe est valide return null autrement
	public static Employe CreerEmploye(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse, int salaire, GregorianCalendar DATE_EMBAUCHE) {
		Calendar aujourdhui = Calendar.getInstance();
		if(
			aujourdhui.get(Calendar.YEAR) - laDate.get(Calendar.YEAR)  > AGE_MIN_LEGALE &&
			aujourdhui.get(Calendar.YEAR) - laDate.get(Calendar.YEAR)  < AGE_MAX_LEGALE
		) {
			return new Employe(leNom, lePrenom, laDate, lAdresse, salaire, DATE_EMBAUCHE);
		}else {
			return null;
		}
	}
	
	public int getSalaire() {
		return salaire;
	}
	
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	//parm augmentation => pourcentage de l'augmentation 
	public void augmenterLeSalaire(double augmentation) {
		if(augmentation >0) {
			this.salaire = (int) Math.round(this.salaire * (1 + augmentation / 100)) ;
		}
	}
	
	// retourne le nombre d'annuite d'une instance (toute annee commencer est cotmper)
	public int calculAnnuite() {
		Calendar aujourdhui = Calendar.getInstance();
		int nb_annee =  aujourdhui.get(Calendar.YEAR) - this.DATE_EMBAUCHE.get(Calendar.YEAR);
		if (aujourdhui.get(Calendar.MONTH) > this.DATE_EMBAUCHE.get(Calendar.MONTH)) {
			nb_annee +=1;
		}else if(
				aujourdhui.get(Calendar.MONTH) == this.DATE_EMBAUCHE.get(Calendar.MONTH) &&
				aujourdhui.get(Calendar.DAY_OF_MONTH) > this.DATE_EMBAUCHE.get(Calendar.DAY_OF_MONTH)
				) {
			nb_annee +=1;
		}
		return nb_annee;
  	}
	
}
