
public class Robot {
	private String id;
	private String name;
	private int positionX = 0;
	private int positionY = 0;
	private int orientation = 1;
	private static final int position_min = 1;
	private static int nbRobot;
	
	
	public Robot(String name, int positionX, int positionY, int orientation ) {
		if(name == "" || name == null) {
			this.name = "ROB" + nbRobot;
		}else {
			this.name = name;
		}
		
		if(positionX >= position_min && positionY >= position_min) {
			this.positionX = positionX;
			this.positionY = positionY;
		}
		
		if (orientation >= 1 && orientation <= 4) {
			this.orientation = orientation;
		}else {
			this.orientation = 1;
		}
		
		this.id = "ROB" + nbRobot;
		nbRobot ++;
	}
	
	public Robot(String name) {
		if(name == "" || name == null) {
			this.name = "ROB" + nbRobot;
		}else {
			this.name = name;
		}
		
		this.id = "ROB" + nbRobot;
		nbRobot ++;
	}
	
	public void changeOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	public void moove() {
		if (this.orientation == 1){
			this.positionX ++;
		}
		else if(this.orientation ==2) {
			this.positionY ++;
		}
		else if (this.orientation ==3 && this.positionX >= position_min) {
			this.positionX --;
		}
		else {
			if (this.positionY >= position_min) {
				this.positionY --;
			}
		}
	}
	
	public void afficheToi() {
		System.out.print("nom " + this.name + " ordonnes " + this.positionX + " abscisse " + this.positionY  + " orientation "+ this.orientation);
	}
	
	public String toString() {
		return  "nom " + this.name + " ordonnes " + this.positionX + " abscisse " + this.positionY  + " orientation "+ this.orientation;
	}
}

