package atelier7;

import java.util.*;
import atelier7.Adresse;


	public class Personne{
		private static final Adresse ADRESSE_INCONNUE = null;
		private String nom;
		private String prenom;
		private final GregorianCalendar DATE_NAISSANCE;
		private Adresse adresse=ADRESSE_INCONNUE;
	    private static int nbPersonne;
				
		/**
		 * Constructeur de Personne
		 * @param leNom le nom de la personne
		 * @param lePrenom le pr�nom de la personne
		 * @param laDate la date de naissance de la personne
		 * @param lAdresse l'adresse de la personne
		 */
		public Personne(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse){
			nom = leNom.toUpperCase();
			prenom=lePrenom;
			DATE_NAISSANCE=laDate;
			adresse=lAdresse;
			nbPersonne++;
		}
		
		/** 
		 * Constructeur de Personne
		 * @param leNom le nom de la personne
		 * @param lePrenom le pr�nom de la personne
		 * @param j le jour de naissance
		 * @param m le mois de naissance
		 * @param a l'ann�e de naissance
		 * @param numero le n� de la rue
		 * @param rue la rue
		 * @param code_postal le code postal de l'adresse
		 * @param ville la ville ou la personne habite
		 */
		public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
			this(leNom, lePrenom, new GregorianCalendar(a,m,j),new Adresse(numero,rue,code_postal,ville));
		}

		/**
		 * Accesseur
		 * @return retourne le nom
		 */
		public String getNom(){
			return nom;
		}
		/**
		 * Accesseur
		 * @return retourne le pr�nom
		 */
		public String getPrenom(){
			return prenom;
		}
		/**
		 * Accesseur
		 * @return retourne la date de naissance	 
		 */
		public GregorianCalendar getDATE_NAISSANCE() {
			return DATE_NAISSANCE;
		}
		/**
		 * Accesseur
		 * @return retourne l'adresse	 
		 */
		public Adresse getAdresse() {
			return adresse;
		}
		/**
		 * Modificateur
		 * @param retourne l'adresse	 
		 */
		public void setAdresse(Adresse a) {
			adresse=a;
		}
			
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		
		public static int getNbPersonne() {
			return nbPersonne;
		}

		public String toString(){
			String result="\nNom : "+nom+"\n"
			+"Prenom : "+prenom+"\n"+
			"Ne(e) le : "+DATE_NAISSANCE.get(Calendar.DAY_OF_MONTH)+
			"-"+DATE_NAISSANCE.get(Calendar.MONTH)+
			"-"+DATE_NAISSANCE.get(Calendar.YEAR)+"\n"+
			"Adresse : "+
			adresse.toString();
			return result;
		}
		
		// prend en param deux Personne et retourne vrai si la première passer en param est plus age que la seconde
		public static boolean plusAgee(Personne personne1, Personne personne2) {
			return (personne1.getDATE_NAISSANCE().getTimeInMillis() - personne2.getDATE_NAISSANCE().getTimeInMillis() > 0);
		}
		// prend en param une personne et retourne vrai si l'instance qui appelle la méthode est plus agée que celle-ci
		public boolean plusAgee(Personne personne2) {
			return (this.getDATE_NAISSANCE().getTimeInMillis() - personne2.getDATE_NAISSANCE().getTimeInMillis() > 0);
		}
		
		// prend en param une personne est retourne vrai si elle est identique à celle appelant la méthode
		public boolean equals(Object personne2) {
			if(personne2 instanceof Personne) {
				Personne personne3 = (Personne) personne2;
				return (
					this.getNom().equals(personne3.getNom()) &&
					this.getPrenom().equals(personne3.getPrenom())&&
					!this.getDATE_NAISSANCE().after(personne3.getDATE_NAISSANCE())
				);
			}else {
				return false;
			}
		}
	}

