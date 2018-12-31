import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Plateau {
	int nb_couronnes;
	int nb_champs;
	int nb_prairie;
	int nb_mer;
	int nb_foret;
	int nb_mine;
	
	
	
	public static void afficher(String[][] list) {
		for (int i=0 ; i<9 ; i++) {
			for (int j=0; j<9 ; j++) {
			System.out.print(list[i][j]);
			if (j==8) {
				System.out.print("\n");
			}
		}
		}
	
		
	}
		
//	public static int selection(ArrayList<Integer> nbpioche) {
//
//		Scanner scan = new Scanner(System.in);
//		int select;
//		do{
//			System.out.println("Donner le numero du domino que vous voulez prendre");
//			select = scan.nextInt();
//		}
//		while(nbpioche.contains(select)!=true);
//		nbpioche.remove(new Integer (select));
//		
//		return select;
//	}
	
	public static int[] poser (ArrayList<String> Domino, String[][] grille) {
		Scanner scan = new Scanner(System.in);
		String ho_ve;
		String part_pos;
		String type_1 = Domino.get(1);
		String type_2 = Domino.get(3);
		do{
			System.out.println("pose horizontale (h) ou vertivale (v)");
			ho_ve = scan.nextLine();
		}
		while(ho_ve.equals("h")==false && ho_ve.equals("v")==false);
		do {
			System.out.println("quelle partie poser? "+ type_1 +" ou "+ type_2);
			part_pos= scan.nextLine();
		}
		while(part_pos.equals(type_1)==false && part_pos.equals(type_2)==false);
		int abs ;
		int ord ;
			System.out.println("coordonnées de la partie a poser");
			abs = scan.nextInt();
			ord = scan.nextInt();
			int[] coord= new int[2];
		if (part_pos.equals(type_1) && ho_ve.equals("h")){
			grille[abs-1][ord-1]= part_pos;
			grille[abs-1][ord]= type_2;
			coord[0] = abs;
			coord[1] = ord;
		}
		if (part_pos.equals(type_1) && ho_ve.equals("v")) {
			grille[abs-1][ord-1]= part_pos;
			grille[abs][ord-1]= type_2;
		}
		return coord;
	}
	
	public static String confirmation() {
		System.out.println("confirmer cette dispo?");
		System.out.println("oui/non");
		Scanner scan = new Scanner(System.in);
		String conf = scan.nextLine();
		
		
		return conf;
	}
	public static void annulation(String[][] grille, int[]coord) {
		
	}
	
	public void verif() {
		
	}
	
	public void compte_pts(ArrayList<ArrayList<String>> grille){
		
	}

}
