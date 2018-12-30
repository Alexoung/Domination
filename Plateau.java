import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Plateau {
	
	
	
	public static void afficher(int[][] list) {
		for (int i=0 ; i<9 ; i++) {
			for (int j=0; j<9 ; j++) {
			System.out.print(list[i][j]);
			if (j==8) {
				System.out.print("\n");
			}
		}
		}
	
		
	}
		
	public static int selection(ArrayList<Integer> nbpioche) {

		Scanner scan = new Scanner(System.in);
		int select;
		do{
			System.out.println("Donner le numero du domino que vous voulez prendre");
			select = scan.nextInt();
		}
		while(nbpioche.contains(select)!=true);
		nbpioche.remove(new Integer (select));
		
		return select;
	}
	
	public void poser () {
		
	}
	
	public void verif() {
		
	}

}
