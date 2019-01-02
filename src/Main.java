import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		//IMPORATATION DE LA LISTE CSV
		
		ArrayList<ArrayList<String>> allist = new ArrayList<ArrayList<String>>();
		try {

			Scanner scanner = new Scanner(new File("dominos.csv"));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] elements = line.split(",");
				ArrayList<String> currentdom = new ArrayList<String>();
				for (int i=0; i<elements.length; i++) {
					currentdom.add(elements[i]);
				}
				allist.add(currentdom);

			}
			//System.out.println(allist.get(1).get(3));
			//System.out.println(list[2][1]);

		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
		}
		
		
		//DEBUT DE JEU
		System.out.println("Nombre de joueurs?");
		Scanner scan = new Scanner(System.in);
		int nbj = scan.nextInt();
		Joueur[] ljoueurs = new Joueur[nbj];
		ArrayList<String> dispcouleur = new ArrayList<String>();
		dispcouleur.add("bleu");
		dispcouleur.add("rouge");
		dispcouleur.add("vert");
		dispcouleur.add("jaune"); 
		
		
		switch (nbj) {
		
		case 2 : 
			for (int i=0 ; i<nbj ; i++) {
				ljoueurs[i] = Joueur.nvjoueur(dispcouleur, i);
				//System.out.println(n);
			}
			
			
			Stack<Integer> pioche = new Stack<Integer>();
			Dominos.melange(pioche);
			
			
			do {
			ArrayList<Integer> currentpioche = Dominos.piocher(nbj, pioche, allist);
			for (int i=0; i<nbj; i++) {
				System.out.println("\n"+"Dominos disponibles" + "\n");
				System.out.println(allist.get(0));
				Iterator<Integer> iterator= currentpioche.iterator();
				while(iterator.hasNext()) {
					System.out.println(allist.get(iterator.next()));
				}

				System.out.println("\n" + "Tour de "+ ljoueurs[i].getName());
				System.out.println("Grille de " + ljoueurs[i].getName());
				String[][][] grille_init = ljoueurs[i].grille;
				Plateau.afficher(grille_init);
				int select = Dominos.selection(currentpioche);
				//String conf;
				String [][][] grille_suivante;
				
				do{
					System.out.println("Domino à placer");
					System.out.println(allist.get(select) + "\n");
					Plateau.afficher(ljoueurs[i].grille);
					grille_suivante = Plateau.poser(allist.get(select), ljoueurs[i].grille);
					Plateau.afficher(grille_suivante);
					//conf = Plateau.confirmation();
					}//MANQUE CONFIRMATION ET ANNULATION DE LA DISPOSITION SI NON CONFIRMEE
				while(Plateau.confirmation().equals("oui")==false);
				ljoueurs[i].grille=grille_suivante;
				
				
				
			}
			}
			while(pioche.empty()==false);
			
//			System.out.println("Grille de " + ljoueurs[1].getName());
//			Plateau.afficher(ljoueurs[1].grille);
			
			
//			for (int i=0 ; i<9 ; i++) {
//				for (int j=0; j<9 ; j++) {
//				System.out.print(joueurs[1].grille[i][j]);
//				if (j==8) {
//					System.out.print("\n");
//				}
//			}
//		}
			
			
			
//			while (pioche.empty()==false) {
//			pioche.peek();
//			pioche.pop();
//			//System.out.println(pioche);
//		}

		case 3 : 
			
			
			
		case 4 : 
		
		}
			
			
	}
		
	
	
	
	
	
	}

