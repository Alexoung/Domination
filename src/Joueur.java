import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Joueur {
	String name ;
	String color;
	String[][][] grille;
	Fenetre fen;
	
	
	
	public Joueur (String name, String color, String[][][] grille, Fenetre fen) {
		this.name = name;
		this.color = color;
		this.grille = grille;
		this.fen = fen;
		
	}



	public Fenetre getFen() {
		return fen;
	}



	public void setFen(Fenetre fen) {
		this.fen = fen;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}
	


	public String[][][] getGrille() {
		return grille;
	}



	public void setGrille(String[][][] grille) {
		this.grille = grille;
	}

	
	public static Joueur nvjoueur(ArrayList<String> list, int nbj){
		Scanner scan = new Scanner(System.in);
		String couleur;
		//int[][][] grille;
		System.out.println("NOM du joueur "+ (nbj+1));
		String nom = scan.nextLine();
			do {
			System.out.println("Couleur : ");
			for (int i=0; i< list.size(); i++) {
				System.out.print(list.get(i)+ "  ");
			}
			couleur = scan.nextLine();
			}
		while(list.contains(couleur)!=true);
		String[][][] grille = new String[9][9][2];
		for (int i=0; i<9 ; i++) {
			for(int j=0 ; j<9 ; j++) {
				grille[i][j][0] = "0";
				grille[i][j][1] = "0";
			}
		}
		grille[4][4][0]= "Chateau";
		list.remove(new String(couleur));
		Fenetre fen = new Fenetre(nom);
		
		return new Joueur(nom, couleur, grille, fen );
		
	}



}
