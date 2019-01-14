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
		ArrayList<ArrayList<String>> allist = Dominos.importation();
//		ArrayList<ArrayList<String>> allist = new ArrayList<ArrayList<String>>();
//		try {
//
//			Scanner scanner = new Scanner(new File("dominos.csv"));
//			while (scanner.hasNext()) {
//				String line = scanner.nextLine();
//				String[] elements = line.split(",");
//				ArrayList<String> currentdom = new ArrayList<String>();
//				for (int i=0; i<elements.length; i++) {
//					currentdom.add(elements[i]);
//				}
//				allist.add(currentdom);
//
//			}
//			//System.out.println(allist.get(1).get(3));
//			//System.out.println(list[2][1]);
//
//		} 
//		catch (FileNotFoundException e) {
//			System.out.println("Fichier non trouvé");
//		}
		
		
		//DEBUT DE JEU
		ArrayList<Integer> debut_order =  new ArrayList<Integer>(4);
		ArrayList<Integer> current_order =new  ArrayList<Integer>(4);
		ArrayList<Integer> next_order = new ArrayList<Integer>(4);
		next_order.add(null);
		next_order.add(null);
		next_order.add(null);
		next_order.add(null);
		//System.out.println(next_order.size());
		int nbj;
		
		
		System.out.println("Nombre de joueurs?");
		Scanner scan = new Scanner(System.in);
		nbj = scan.nextInt();
		Joueur[] ljoueurs = new Joueur[nbj];
		ArrayList<String> dispcouleur = new ArrayList<String>();
		dispcouleur.add("bleu");
		dispcouleur.add("rouge");
		dispcouleur.add("vert");
		dispcouleur.add("jaune"); 
		//System.out.println(next_order);
		
			for (int i=0 ; i<nbj ; i++) {
				ljoueurs[i] = Joueur.nvjoueur(dispcouleur, i);
				//System.out.println(n);
			}
			
			
			
			Stack<Integer> pioche = new Stack<Integer>();
			Dominos.melange(pioche);
			Dominos.setup_retirer(nbj, pioche);
			debut_order = Tour.ordre_debut(nbj);
//			Random random = new Random();
//			int test = 0;
//			while( test != 10) {
//			System.out.println(random.nextInt(nbj));
//			test++;
//			}
			Tour tourp= new Tour(debut_order, debut_order);
			do {
				ArrayList<Integer> ordre_tour = new ArrayList<Integer>(tourp.getNext_order());
				tourp.setCurrent_order(ordre_tour);
			ArrayList<Integer> currentpioche = Dominos.piocher(nbj, pioche, allist);
			ArrayList<Integer> pioche_complete = new ArrayList<Integer>();
			for (int a : currentpioche) {
				pioche_complete.add(a);
			}
			//System.out.println(tourp.getCurrent_order());
			while (currentpioche.isEmpty()==false) {
				
				System.out.println("\n"+"Dominos disponibles" + "\n");
				System.out.println("current " + current_order);
				System.out.println("next " + next_order);
				System.out.println(allist.get(0));
				Iterator<Integer> iterator= currentpioche.iterator();
				while(iterator.hasNext()) {
					try {
					System.out.println(allist.get(iterator.next()));
					}
					catch(java.lang.IndexOutOfBoundsException e) {}
				}
				
				
				
				
				int vajouer=tourp.getCurrent_order().get(0);
				tourp.getCurrent_order().remove(0);
				

				System.out.println("\n" + ">>> Tour de "+ ljoueurs[vajouer].getName() + " en " +ljoueurs[vajouer].getColor());
				System.out.println("Grille de " + ljoueurs[vajouer].getName());
				String[][][] grille_init = ljoueurs[vajouer].getGrille();
				Plateau.afficher(grille_init);
				
				
				int[] tb = new int[2];
				tb = Dominos.selection(currentpioche);
				int select = tb[0];
				int ordre_dom = pioche_complete.indexOf(select);
				
				next_order.set(ordre_dom, vajouer);
				System.out.println(next_order);
				String [][][] grille_suivante;
				
				do{
					System.out.println("Domino à placer");
					System.out.println(allist.get(select) + "\n");
					Plateau.afficher(ljoueurs[vajouer].getGrille());
					grille_suivante = Plateau.poser(allist.get(select), ljoueurs[vajouer].getGrille());
					Plateau.afficher(grille_suivante);
					//conf = Plateau.confirmation();
					}//MANQUE CONFIRMATION ET ANNULATION DE LA DISPOSITION SI NON CONFIRMEE
				while(Plateau.confirmation().equals("oui")==false);
				ljoueurs[vajouer].setGrille(grille_suivante);
				
				tourp.setNext_order(next_order);
				
				
				
			}
			}
			while(pioche.empty()==false);
			
			//FIN DE JEU - Calcul des scores et determination du gagnant
			int [][] scoresJoueurs = new int[nbj][3];
			for(int i = 0; i<nbj; i++) {
				int[] scoreJoueur = Plateau.compte_pts(ljoueurs[i].getGrille());
				scoresJoueurs[i] = scoreJoueur;
			}
			int scoreMax = 0; int casesMax = 0; int couronnesMax = 0;
			int vainqueurScore = 0; int vainqueurCases = 0; int vainqueurCouronnes = 0;
			boolean egaliteScore = false; boolean egaliteCases = false; boolean egaliteCouronnes = false;
			for (int j = 0; j<nbj; j++) {
				if (scoresJoueurs[j][0] > scoreMax) {
					scoreMax = scoresJoueurs[j][0];
					vainqueurScore = j;
				}
				if (scoresJoueurs[j][1] > casesMax) {
					casesMax = scoresJoueurs[j][1];
					vainqueurCases = j;
				}
				if (scoresJoueurs[j][2] > couronnesMax) {
					couronnesMax = scoresJoueurs[j][2];
					vainqueurCouronnes = j;
				}
			}
			for (int k = 0; k<nbj; k++) {
				for (int m = 0; m<nbj; m++) {
					if (k != m) {	
						if (scoresJoueurs[k][0] == scoresJoueurs[m][0]) {
							if (scoresJoueurs[k][0] == scoreMax) {
								egaliteScore = true;
							}
						}
					}
				}
			}
			if (egaliteScore == false) {
				System.out.println("Le joueur " + (vainqueurScore+1) + " a gagné. Félicitations !");
			}
			if (egaliteScore) {
				for (int k = 0; k<nbj; k++) {
					for (int m = 0; m<nbj; m++) {
						if (k != m) {	
							if (scoresJoueurs[k][1] == scoresJoueurs[m][1]) {
								if (scoresJoueurs[k][1] == casesMax) {
									egaliteCases = true;
								}
							}
						}
					}
				}
				if (egaliteCases == false) {
					System.out.println("Le joueur " + (vainqueurCases+1) + " a gagné. Félicitations !");
				}
				if (egaliteCases) {
					for (int k = 0; k<nbj; k++) {
						for (int m = 0; m<nbj; m++) {
							if (k != m) {	
								if (scoresJoueurs[k][2] == scoresJoueurs[m][2]) {
									if (scoresJoueurs[k][2] == couronnesMax) {
										egaliteCouronnes = true;
									}
								}
							}
						}
					}
					if (egaliteCouronnes == false) {
						System.out.println("Le joueur " + (vainqueurCouronnes+1) + " a gagné. Félicitations !");
					}
					if (egaliteCouronnes) {
						System.out.println("Il est impossible de départager les joueurs. Ils sont donc tous désignés victorieux. Félicitations !");
					}
				}
			}
			
			
	}
	public static void set_jeu() {
		
	}
		
	public static void jouer() {
		
	}
	
	
	
	
	}

