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


		do{System.out.println("Nombre de joueurs?");
		Scanner scan = new Scanner(System.in);
		nbj = scan.nextInt();}
		while(nbj>4);
		Joueur[] ljoueurs = new Joueur[nbj];
		ArrayList<String> dispcouleur = new ArrayList<String>();
		dispcouleur.add("bleu");
		dispcouleur.add("rouge");
		dispcouleur.add("vert");
		dispcouleur.add("jaune"); 
		//System.out.println(next_order);

		for (int i=0 ; i<nbj ; i++) {
			ljoueurs[i] = Joueur.nvjoueur(dispcouleur, i);

			//ljoueurs[i].getFen().colorier(ljoueurs[i].getFen().getListbutton()[2][4]);
			//System.out.println(n);
		}

		
		
		



		Stack<Integer> grd_pioche = new Stack<Integer>();
		Dominos.melange(grd_pioche);
		Dominos.setup_retirer(nbj, grd_pioche);
		debut_order = Tour.ordre_debut(nbj);
		ArrayList<Integer> premiere_pioche = Dominos.piocher(nbj, grd_pioche, allist);
		ArrayList<Integer> prems_complet = new ArrayList<Integer>(premiere_pioche);
		Tour tourp = new Tour(debut_order, debut_order, prems_complet);

		while (premiere_pioche.isEmpty()==false) {

			System.out.println("\n"+"Dominos disponibles" + "\n");
			//System.out.println("current " + current_order);
			//System.out.println("next " + next_order);
			System.out.println(allist.get(0));
			Iterator<Integer> iterator= premiere_pioche.iterator();
			while(iterator.hasNext()) {
				try {
					System.out.println(allist.get(iterator.next()));
				}
				catch(java.lang.IndexOutOfBoundsException e) {}
			}


			int vajouer =  debut_order.get(0);
			debut_order.remove(0);

			System.out.println("\n" + ">>> Tour de "+ ljoueurs[vajouer].getName() + " en " +ljoueurs[vajouer].getColor());
			System.out.println("Grille de " + ljoueurs[vajouer].getName());
			String[][][] grille_init = ljoueurs[vajouer].getGrille();
			Plateau.afficher(grille_init);


			int[] tb = new int[2];
			tb = Dominos.selection(premiere_pioche);
			int select = tb[0];
			int ordre_dom = prems_complet.indexOf(select);

			next_order.set(ordre_dom, vajouer);
		}
		//System.out.println(next_order);
		tourp.setNext_order(next_order);



		String [][][] grille_suivante;
		do {
			ArrayList<Integer> ordre_tour = new ArrayList<Integer>(tourp.getNext_order());
			tourp.setCurrent_order(ordre_tour);
			ArrayList<Integer> currentpioche = Dominos.piocher(nbj, grd_pioche, allist);
			ArrayList<Integer> pioche_complete = new ArrayList<Integer>(currentpioche);
			int classement =0;

			while(currentpioche.isEmpty()==false) {
				


				int vajouer=tourp.getCurrent_order().get(0);
				tourp.getCurrent_order().remove(0);


				System.out.println("\n" + ">>> Tour de "+ ljoueurs[vajouer].getName() + " en " +ljoueurs[vajouer].getColor());
				do{
					System.out.println("Domino à placer");
					System.out.println(allist.get(tourp.getLast_pioche().get(classement)) + "\n");
					Plateau.afficher(ljoueurs[vajouer].getGrille());
					grille_suivante = Plateau.poser(allist.get(tourp.getLast_pioche().get(classement)), ljoueurs[vajouer].getGrille());
					Plateau.afficher(grille_suivante);
					//conf = Plateau.confirmation();
				}//MANQUE CONFIRMATION ET ANNULATION DE LA DISPOSITION SI NON CONFIRMEE
				while(Plateau.confirmation().equals("oui")==false);
				
				ljoueurs[vajouer].setGrille(grille_suivante);
				ljoueurs[vajouer].getFen().color_fenetre(ljoueurs[vajouer]);

				System.out.println("Grille de " + ljoueurs[vajouer].getName());
				String[][][] grille_init = ljoueurs[vajouer].getGrille();
				Plateau.afficher(grille_init);

				System.out.println("\n"+"Dominos disponibles" + "\n");
				//System.out.println("current " + current_order);
				//System.out.println("next " + next_order);
				System.out.println(allist.get(0));
				Iterator<Integer> iterator= currentpioche.iterator();
				while(iterator.hasNext()) {
					try {
						System.out.println(allist.get(iterator.next()));
					}
					catch(java.lang.IndexOutOfBoundsException e) {}
				}

				int [] tb = Dominos.selection(currentpioche);
				int select = tb[0];
				int ordre_dom = pioche_complete.indexOf(select);

				next_order.set(ordre_dom, vajouer);
				System.out.println(next_order);



				tourp.setNext_order(next_order);
				classement++;
				
				if(grd_pioche.empty()) {
					System.out.println("\n" + ">>> Tour de "+ ljoueurs[vajouer].getName() + " en " +ljoueurs[vajouer].getColor());
					do{
						System.out.println("Domino à placer");
						System.out.println(allist.get(tourp.getLast_pioche().get(classement)) + "\n");
						Plateau.afficher(ljoueurs[vajouer].getGrille());
						grille_suivante = Plateau.poser(allist.get(tourp.getLast_pioche().get(classement)), ljoueurs[vajouer].getGrille());
						Plateau.afficher(grille_suivante);
					}//MANQUE CONFIRMATION ET ANNULATION DE LA DISPOSITION SI NON CONFIRMEE
					while(Plateau.confirmation().equals("oui")==false);
					ljoueurs[vajouer].getFen().color_fenetre(ljoueurs[vajouer]);
					ljoueurs[vajouer].setGrille(grille_suivante);
					
				}
			
			}
			tourp.setLast_pioche(pioche_complete);

		}while(grd_pioche.empty()==false);



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





}

















