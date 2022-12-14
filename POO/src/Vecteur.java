import static java.lang.Math.sqrt;

public class Vecteur {
	private float x = 0;
	private float y = 0;
	private float z = 0;
	
	public Vecteur(float x, float y,float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vecteur() {

	}
	
	public void afficheCor() {
		System.out.print("< " + this.x + ", " + this.y + ", " + this.z + " >");
	}
	
	public double getNorme() {
		return sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
	
	public double produitScalaire(Vecteur vecteur) {
		return vecteur.x * this.x + vecteur.y * this.y + vecteur.z * this.z;
	}
	public static double produitScalaire(Vecteur vecteur, Vecteur vecteur2) {
		return vecteur.x * vecteur2.x + vecteur.y * vecteur2.y + vecteur.z * vecteur2.z;
	}
	
	public double sommeVecteur(Vecteur vecteur) {
		return  vecteur.x + this.x + vecteur.y + this.y + vecteur.z + this.z;
	}
	
	public static String sommeVecteur(Vecteur vecteur, Vecteur vecteur2) {
		return  "< " + (vecteur.x + vecteur2.x) + ", "+ (vecteur.y + vecteur2.y) + ", " +(vecteur.z + vecteur2.z) + " >";
	}
	
}
