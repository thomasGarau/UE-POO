package atelier7;

import java.util.*;
import atelier7.Adresse;


	public class Personne{
		protected static final Adresse ADRESSE_INCONNUE = null;
		protected String nom;
		protected String prenom;
		protected final GregorianCalendar dateNaissance;
		protected Adresse adresse=ADRESSE_INCONNUE;
	    private static int nbPersonne;
		
		public static int getNbPersonne() {
			return nbPersonne;
		}

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
			dateNaissance=laDate;
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
		public GregorianCalendar getDateNaissance() {
			return dateNaissance;
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
		public String toString(){
			String result="\nNom : "+nom+"\n"
			+"Prenom : "+prenom+"\n"+
			"Ne(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
			"-"+dateNaissance.get(Calendar.MONTH)+
			"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
			"Adresse : "+
			adresse.toString();
			return result;
		}
		
		// prend en param deux Personne et retourne vrai si la première passer en param est plus age que la seconde
		public static boolean plusAgee(Personne personne1, Personne personne2) {
			return (personne1.getDateNaissance().getTimeInMillis() - personne2.getDateNaissance().getTimeInMillis() > 0);
		}
		// prend en param une personne et retourne vrai si l'instance qui appelle la méthode est plus agée que celle-ci
		public boolean plusAgee(Personne personne2) {
			return (this.getDateNaissance().getTimeInMillis() - personne2.getDateNaissance().getTimeInMillis() > 0);
		}
		
		// prend en param une personne est retourne vrai si elle est identique à celle appelant la méthode
		public boolean equals(Personne personne2) {
			return (
				this.getNom().equals(personne2.getNom()) &&
				this.getPrenom().equals(personne2.getPrenom())&&
				!this.getDateNaissance().after(personne2.getDateNaissance())
			);
				
		}
	}
