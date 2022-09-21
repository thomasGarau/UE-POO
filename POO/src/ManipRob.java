
public class ManipRob {
	
	 public static void main (String[] args){
		 Robot robot1 = new Robot("toto", 10, 20, 3);
		 Robot robot2 = new Robot("titi");
		 Robot robot3 = new Robot("", 0, -3, -3);
		 
		 robot1.moove();
		 robot1.moove();
		 robot2.moove();
		 robot2.changeOrientation(2);
		 robot2.moove();
		 robot2.moove();
		 
		 robot1.afficheToi();
		 robot2.afficheToi();
		 System.out.print(robot1.toString() + "\n");
		 System.out.print(robot3.toString());
	 }
}
