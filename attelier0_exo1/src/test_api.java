import static java.lang.Math.*;
import java.util.concurrent.ThreadLocalRandom;

public class test_api {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.print(Math.PI + "\n");
			System.out.print(Math.random() + "\n");
			int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
			System.out.print(randomNum + "\n");
			int randomNum2 = ThreadLocalRandom.current().nextInt(1, 20);
			int randomNum3 = ThreadLocalRandom.current().nextInt(1, 20);
			System.out.print(Math.max(randomNum2,randomNum3) + " randomNum2 " + randomNum2 + " randomNum3 " + randomNum3);
			String str1 = "thomas";
			String str2 = "homas";
			;
			if (str1.compareTo(str2) == 0){
				System.out.print(str1 + " "+ str2);
			}else {
				System.out.print(str2 + " " +str1);
			}
	}

}
