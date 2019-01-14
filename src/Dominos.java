import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Dominos {

	//	String numero;
	//	String gauche;
	//	String droite;
	//	String nb_couronne;
	//	
	//	
	//	public Dominos (String gauche, String droite, String nb_couronne, String numero) {
	//		this.droite = droite;
	//		this.gauche = gauche;
	//		this.nb_couronne = nb_couronne;
	//		this.numero = numero;
	//		
	//	}


	
	public static ArrayList<ArrayList<String>> importation() {
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
		
		return allist;
	
	}
	
	
	
	public static void melange(Stack<Integer> pioche) {
		while(pioche.size()!=48) {
			Random rand = new Random();
			//int num = (int)(Math.random()*49);
			int num = rand.nextInt(49);
			//System.out.println(num);
			if (pioche.search(num)==-1) {
				pioche.push(num);
			}
		}
		System.out.println(pioche);
		
	}
	
	public static ArrayList<Integer> piocher(int nbj, Stack<Integer> pioche, ArrayList<ArrayList<String>> allist) {
		
		ArrayList<Integer> tb_num_pioche = new ArrayList<Integer>();
		if (nbj == 2) {
			System.out.println("hello");
			for (int i=0;  i<4; i++) {
				int n = pioche.pop();
				System.out.println(n);
				//System.out.println(n);
				tb_num_pioche.add(n+1);
			}
		}
		else {
			for (int i=0;  i<nbj; i++) {
				int n = pioche.pop();
				//System.out.println(n);
				tb_num_pioche.add(n+1);
		}
		
		//System.out.println(allist.get(n+1));
			
		}
		Collections.sort(tb_num_pioche);
		return tb_num_pioche; // DOMINOS MIS A DISPOSITION APRES PIOCHE
	}
	
	public static void setup_retirer(int nbj, Stack<Integer> pioche) {
		int a_enlever = 12*(4-nbj);
		
		for (int i = 0; i<a_enlever ; i++) {
			pioche.pop();
		}
		System.out.println(a_enlever + " dominos ont été retirés");
	}
	
	public static int[] selection(ArrayList<Integer> nbpioche) {
		
		Scanner scan = new Scanner(System.in);
		int select;
		int indexselect;
		int[] tb= new int[2];
		do{
			System.out.println("Donner le numero du domino que vous voulez prendre");
			select = scan.nextInt();
		}
		while(nbpioche.contains(select)!=true);
		indexselect = nbpioche.indexOf(select);
		nbpioche.remove(new Integer (select));
		//nbpioche.set(indexselect, null);
		
		//System.out.println(indexselect);
		tb[0]=select;
		tb[1]= indexselect;
		return tb;
	}


}



