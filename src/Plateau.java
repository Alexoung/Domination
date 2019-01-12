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
//		System.out.print("\n");
//		System.out.print("Couronnes");
//		System.out.print("\n");
//		System.out.print("  ");
//		for (int a=0 ; a<9 ; a++) {
//			System.out.print(a+1);
//			
//		}System.out.print("\n");
//		for (int i=0 ; i<9 ; i++) {
//			System.out.print((i+1));
//			System.out.print(" ");
//			for (int j=0; j<9 ; j++) {
//			
//			System.out.print((list[i][j][1]));
//				if (j==8) {
//					System.out.print("\n");
//				}
//			}
//		}
		
	}
		
	
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
		String part_autre;
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
			if (part_pos == type_1) {
				part_autre = type_2;
			}
			else {
				part_autre = type_1;
			}
		}
		while(part_pos.equals(type_1)==false && part_pos.equals(type_2)==false);
		int lgn ;
		int cln ;
		int a_lgn;
		int a_cln;
		Boolean trop_long = null;
		do {
			
			System.out.println("coordonnées de la partie a poser");
			System.out.println("ligne");
			lgn = scan.nextInt();
			System.out.println("colonne");
			cln = scan.nextInt();
			a_lgn = lgn;
			a_cln = cln;
			//int[] coord= new int[2];
			//System.out.println(pris(lgn,cln,grille));
		
			System.out.println("retourner?");
			System.out.println("deuxieme partie en haut ou a gauche si oui");
			boolean retourner = Plateau.retourner();
			if ( ho_ve.equals("v") ) {
				
				if(retourner == true) {
					a_lgn = lgn-1;
					a_cln = cln;
				}
				else {
					a_lgn = lgn +1;
					a_cln = cln;
				}
				
			}
			if ( ho_ve.equals("h")) {
				if(retourner == true){
					a_lgn = lgn;
					a_cln = cln-1;
				}
				else {
					a_lgn= lgn;
					a_cln = cln+1;
				}
				
			}
			System.out.println(pris(lgn-1,cln-1,grille));
			System.out.println(pris(a_lgn-1, a_cln-1, grille));
			System.out.println(okautour(lgn-1,cln-1,grille, part_pos));
			System.out.println(okautour(a_lgn-1,a_cln-1,grille,part_autre));
			if ( placement_bon(lgn,cln,a_lgn,a_cln, grille, part_pos, part_autre))  {
			try {
				if (part_pos.equals(type_1) && ho_ve.equals("h") ){
				grille_cop[lgn-1][cln-1][0]= type_1;
				grille_cop[lgn-1][cln-1][1]= crown_1;
				grille_cop[a_lgn-1][a_cln-1][0]= type_2;
				grille_cop[a_lgn-1][a_cln-1][1]= crown_2;
				
			}
			
			if (part_pos.equals(type_2) && ho_ve.equals("h") ){
				grille_cop[lgn-1][cln-1][0]= type_2;
				grille_cop[lgn-1][cln-1][1]= crown_2;
				grille_cop[a_lgn-1][a_cln-1][0]= type_1;
				grille_cop[a_lgn-1][a_cln-1][1]= crown_1;
			}
			if (part_pos.equals(type_1) && ho_ve.equals("v") ) {
				grille_cop[lgn-1][cln-1][0]= type_1;
				grille_cop[lgn-1][cln-1][1]= crown_1;
				grille_cop[a_lgn-1][a_cln-1][0]= type_2;
				grille_cop[a_lgn-1][a_cln-1][1]= crown_2;
			}
			if (part_pos.equals(type_2) && ho_ve.equals("v") ) {
				grille_cop[lgn-1][cln-1][0]= type_2;
				grille_cop[lgn-1][cln-1][1]= crown_2;
				grille_cop[a_lgn-1][a_cln-1][0]= type_1;
				grille_cop[a_lgn-1][a_cln-1][1]= crown_1;
			}
			trop_long=troplong(grille_cop);
			if (trop_long) {
				grille_cop[lgn-1][cln-1][0]= "0";
				grille_cop[lgn-1][cln-1][1]= "0";
				grille_cop[a_lgn-1][a_cln-1][0]= "0";
				grille_cop[a_lgn-1][a_cln-1][1]= "0";
			}
			
				
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Impossible de le placer 'index'");
				if (part_pos.equals(type_1) && ho_ve.equals("h")){
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[a_lgn-1][a_cln-1][0]= "0";
					grille_cop[a_lgn-1][a_cln-1][1]= "0";
				}
				
				if (part_pos.equals(type_2) && ho_ve.equals("h")){
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[a_lgn-1][a_cln-1][0]= "0";
					grille_cop[a_lgn-1][a_cln-1][1]= "0";
				}
				if (part_pos.equals(type_1) && ho_ve.equals("v")) {
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[a_lgn-1][a_cln-1][0]= "0";
					grille_cop[a_lgn-1][a_cln-1][1]= "0";
				}
				if (part_pos.equals(type_2) && ho_ve.equals("v")) {
					grille_cop[lgn-1][cln-1][0]= "0";
					grille_cop[lgn-1][cln-1][1]= "0";
					grille_cop[a_lgn-1][a_cln-1][0]= "0";
					grille_cop[a_lgn-1][a_cln-1][1]= "0";
				}
				
				
			}
			
			}
			else {
				System.out.println("impossible de placer 'check'");
			}
		}
	while(placement_bon(lgn,cln,a_lgn,a_cln, grille, part_pos, part_autre)==false || trop_long==true);
		
		return grille_cop;
	}
	
	public static String confirmation() {
		System.out.println("confirmer cette dispo?");
		System.out.println("oui/non");
		Scanner scan = new Scanner(System.in);
		String conf = scan.nextLine();
		
		
		return conf;
	}
	
	
	public static boolean pris(int ligne, int colonne, String[][][] grille) {
		if (grille[ligne][colonne][0].equals("0")) {
			return false;
		}
		else {
			return true ;
		}
		
	}
	
	public static boolean retourner(){
		Scanner scan = new Scanner(System.in) ; 
		String retourner = scan.nextLine();
		if (retourner.equals("oui")){
			return true;
		}
		if(retourner.equals("non")){
			return false;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean troplong(String[][][] grille) {
		
		for (int i=0 ; i<9; i++) {
			int compteurl=0;
			int compteurc=0;
			for (int j=0; j<9; j++) {
				if (grille[i][j][0].equals("0")==false) {
					compteurl++;
					//System.out.println("compteur lgl" + compteurl);
				}
				if(grille[j][i][0].equals("0")== false) {
					compteurc++;
					//System.out.println("compteur cln" + compteurc);
				}
				if (compteurc>5 ||compteurl >5) {
					return true;
				}
			
			}
			
		}
		return false;
	}
	
	
	public static boolean placement_bon(int lgn, int cln, int a_lgn, int a_cln, String[][][] grille, String part_pos, String part_autre) {
		if ( ((pris(lgn-1,cln-1,grille)==false) && (pris(a_lgn-1, a_cln-1, grille) == false) && (okautour(lgn-1,cln-1,grille, part_pos)==true))
				|| ((pris(lgn-1,cln-1,grille)==false) && (pris(a_lgn-1, a_cln-1, grille) == false) && (okautour(a_lgn-1, a_cln-1, grille, part_autre) == true)) )  {
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean okautour( int ligne, int colonne, String[][][] grille, String type_1) {
		int ligne_h = ligne-1;
		int ligne_b = ligne+1;
		int colonne_g = colonne-1;
		int colonne_d = colonne+1 ;
		try{
			if ((grille[ligne][colonne_g][0].equals(type_1))
			|| (grille[ligne][colonne_d][0].equals(type_1))
			|| (grille[ligne_h][colonne][0].equals(type_1))
			|| (grille[ligne_b][colonne][0].equals(type_1))
			|| (grille[ligne][colonne_g][0].equals("2"))
			|| (grille[ligne][colonne_d][0].equals("2"))
			|| (grille[ligne_h][colonne][0].equals("2"))
			|| (grille[ligne_b][colonne][0].equals("2")) 
//			|| (grille[colonne_g][ligne][0].equals(type_2))
//			|| (grille[colonne_d][ligne][0].equals(type_2))
//			|| (grille[colonne][ligne_h][0].equals(type_2))
//			|| (grille[colonne][ligne_b][0].equals(type_2))
			){
				return true;
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("autre coord");
	}
		return false;
	}
	

	//static dominos.terrain
	// non static dominos.getTerrain()
	
	public void compte_pts(ArrayList<ArrayList<String>> grille){
//		for (int i=0; i<9 ; i++) {
//			for (int j=0; j<9 ;j++) {
//				couleur = grille[i][j];
	}

}
