
public class test {

	public static void main(String[] args) {
		Entier entier = new Entier(0, 10, 5);
		EntierBarjo entierFou = new EntierBarjo(0,10,5,2);
		for(int i =0; i < 20; i++) {
			entier.incremente();
			entierFou.incremente();
		}
		System.out.print("entier " + entier.getValeur() + " entierFou " + entierFou.getValeur() + "\n");
		entier.setValeur(3);
		entierFou.setValeur(2);
		System.out.print("reset " + " entier " + entier.getValeur() + " entierFou " + entierFou.getValeur() + "\n");
		entier.incremente(4);
		entierFou.incremente(2);
		System.out.print("test 2 " + "entier " + entier.getValeur() + " entierFou " + entierFou.getValeur() + "\n");
		System.out.print("toString "  + entierFou.toString() + " equals " +  entierFou.equals(entier)+ "\n");
		Entier entier2 = new Entier(10,0, 5);
		System.out.print(entier2.toString());
	}	

}
