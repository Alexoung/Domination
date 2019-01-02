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
	
	
	
	public static void afficher(String[][][] list) {
		System.out.print("Terrain");
		System.out.print("\n");
		System.out.print("  ");
		for (int a=0 ; a<9 ; a++) {
			System.out.print(a+1);
			
		}System.out.print("\n");
		for (int i=0 ; i<9 ; i++) {
			System.out.print((i+1));
			System.out.print(" ");
			for (int j=0; j<9 ; j++) {
			
			System.out.print((list[i][j][0]));
				if (j==8) {
					System.out.print("\n");
				}
			}
		}
		System.out.print("\n");
		System.out.print("Couronnes");
		System.out.print("\n");
		System.out.print("  ");
		for (int a=0 ; a<9 ; a++) {
			System.out.print(a+1);
			
		}System.out.print("\n");
		for (int i=0 ; i<9 ; i++) {
			System.out.print((i+1));
			System.out.print(" ");
			for (int j=0; j<9 ; j++) {
			
			System.out.print((list[i][j][1]));
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
	
	public static String[][][] poser (ArrayList<String> Domino, String[][][] grille) {
		String[][][] grille_cop= new String[9][9][2];
		for (int i=0; i<9 ; i++) {
			for (int j=0; j<9 ;j++) {
				for (int k=0; k<2 ; k++) {
					grille_cop[i][j][k] = grille[i][j][k];
				}
			}
		}
		
		Scanner scan = new Scanner(System.in);
		String ho_ve;
		String part_pos;
		String type_1 = Domino.get(1);
		String crown_1 = Domino.get(0);
		String type_2 = Domino.get(3);
		String crown_2 = Domino.get(2);
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
		int lgn ;
		int cln ;
			System.out.println("coordonnées de la partie a poser");
			System.out.println("ligne");
			lgn = scan.nextInt();
			System.out.println("colonne");
			cln = scan.nextInt();
			int[] coord= new int[2];
			try {
				if (part_pos.equals(type_1) && ho_ve.equals("h")){
				grille_cop[lgn-1][cln-1][0]= type_1;
				grille_cop[lgn-1][cln-1][1]= crown_1;
				grille_cop[lgn-1][cln][0]= type_2;
				grille_cop[lgn-1][cln][1]= crown_2;
				
			}
			
			if (part_pos.equals(type_2) && ho_ve.equals("h")){
				grille_cop[lgn-1][cln-1][0]= type_2;
				grille_cop[lgn-1][cln-1][1]= crown_2;
				grille_cop[lgn-1][cln][0]= type_1;
				grille_cop[lgn-1][cln][1]= crown_1;
			}
			if (part_pos.equals(type_1) && ho_ve.equals("v")) {
				grille_cop[lgn-1][cln-1][0]= type_1;
				grille_cop[lgn-1][cln-1][1]= crown_1;
				grille_cop[lgn][cln-1][0]= type_2;
				grille_cop[lgn][cln-1][1]= crown_2;
			}
			if (part_pos.equals(type_2) && ho_ve.equals("v")) {
				grille_cop[lgn-1][cln-1][0]= type_2;
				grille_cop[lgn-1][cln-1][1]= crown_2;
				grille_cop[lgn][cln-1][0]= type_1;
				grille_cop[lgn][cln-1][1]= crown_1;
			}
			
				
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Impossible de le placer");
				if (part_pos.equals(type_1) && ho_ve.equals("h")){
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[lgn-1][cln][0]= "0";
					grille_cop[lgn-1][cln][1]= "0";
				}
				
				if (part_pos.equals(type_2) && ho_ve.equals("h")){
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[lgn-1][cln][0]= "0";
					grille_cop[lgn-1][cln][1]= "0";
				}
				if (part_pos.equals(type_1) && ho_ve.equals("v")) {
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[lgn][cln-1][0]= "0";
					grille_cop[lgn][cln-1][1]= "0";
				}
				if (part_pos.equals(type_2) && ho_ve.equals("v")) {
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[lgn][cln-1][0]= "0";
					grille_cop[lgn][cln-1][1]= "0";
				}
				
				
			}
//			System.out.println("retourner?");
//			if (retourner.equals(oui)){
//				
//			}
		
		return grille_cop;
	}
	
	public static String confirmation() {
		System.out.println("confirmer cette dispo?");
		System.out.println("oui/non");
		Scanner scan = new Scanner(System.in);
		String conf = scan.nextLine();
		
		
		return conf;
	}
	
	
	public void verif(int lgn, int cln) {
		
		
	}
	
	public void compte_pts(ArrayList<ArrayList<String>> grille){
//		for (int i=0; i<9 ; i++) {
//			for (int j=0; j<9 ;j++) {
//				couleur = grille[i][j];
	}

}
