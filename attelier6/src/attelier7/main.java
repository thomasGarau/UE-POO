package attelier7;
import java.util.concurrent.ThreadLocalRandom;

public class main {

	public static void main(String[] args) {
		Des d = new Des();
		System.out.print(d.getName() + d.getNb_faces() + "\n");
		System.out.print(d.lancer() + "\n");
		DesPiper dp = new DesPiper("dd", 6, 3);
		for(int i=0; i < 10; i++) {
			System.out.print(dp.lancer() + " \n");
		}
		DesMemoire dm = new DesMemoire(6, "dd");
		for(int i=0; i < 10; i++) {
			System.out.print(dm.lancer() + " memoire " + " \n");
		}
		Des d2 = new Des(2,"");
		Des d3 = new Des(128,"");
		System.out.print("d2 " + d2.toString() + " d3 " + d3.toString());
		
	}

}
