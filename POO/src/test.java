
public class test {

	public static void main(String[] args) {
		Vecteur vecteur1 = new Vecteur(3,2,5);
		Vecteur vecteur2 = new Vecteur(1,2,3);
		vecteur1.afficheCor();
		System.out.print(vecteur1.getNorme());
		vecteur2.afficheCor();
		System.out.print(vecteur2.getNorme());
	}

}
