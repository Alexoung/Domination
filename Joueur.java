import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Joueur {
	String name ;
	String color;
	String[][] grille;
	
	
	
	public Joueur (String name, String color, String[][] grille) {
		this.name = name;
		this.color = color;
		this.grille = grille;
		
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
	


	public String[][] getGrille() {
		return grille;
	}



	public void setGrille(String[][] grille) {
		this.grille = grille;
	}

	
	public static Joueur nvjoueur(ArrayList<String> list, int njoueur){
		Scanner scan = new Scanner(System.in);
		String couleur;
		//int[][] grille;
		System.out.println("NOM du joueur "+ (njoueur+1));
		String nom = scan.nextLine();
			do {
			System.out.println("Couleur : ");
			for (int i=0; i< list.size(); i++) {
				System.out.print(list.get(i)+ "  ");
			}
			couleur = scan.nextLine();
			}
		while(list.contains(couleur)!=true);
		String[][] grille = new String[9][9];
		for (int i=0; i<9 ; i++) {
			for(int j=0 ; j<9 ; j++) {
				grille[i][j] = "0";
			}
		}
		grille[4][4]= "2";
		list.remove(new String(couleur));
		
		return new Joueur(nom, couleur, grille);
		
	}



}
