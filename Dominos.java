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

	public static void main(String[] args){ 

// 		ArrayList<ArrayList<String>> allist = new ArrayList<ArrayList<String>>();

// 		//String[][] list = new String[50][5];
// 		//int ligne = 0;
// 		try {

// 			Scanner scanner = new Scanner(new File("dominos.csv"));
// 			while (scanner.hasNext()) {
// 				String line = scanner.nextLine();
// 				String[] elements = line.split(",");
// 				ArrayList<String> currentdom = new ArrayList<String>();
// 				for (int i=0; i<elements.length; i++) {
// 					currentdom.add(elements[i]);
// 				}
// 				allist.add(currentdom);
// //				ligne+=1;
// //				for (int i =0; i<elements.length; i++) {
// //					list[ligne][i]= elements[i];
// //					ligne+= 1;
// //				}	

// 			}
// 			System.out.println(allist.get(1).get(3));
// 			//System.out.println(list[2][1]);

// 		} 
// 		catch (FileNotFoundException e) {
// 			System.out.println("Fichier non trouvé");
// 		}
	}
	
	
	
	
	Stack<Integer> pioche = new Stack<Integer>();{
	for (int i=0;i<49 ; i++) {
		int num = (int)Math.random()*49;
	}
	
	}
	
	public static void melange(Stack<Integer> pioche) {
		while(pioche.size()!=48) {
			//Random num = new Random();
			int num = (int)(Math.random()*49);
			//System.out.println(num);
			if (pioche.search(num)==-1) {
				pioche.push(num);
			}
		}
		
	}
	
	public static ArrayList<Integer> piocher(int nombre, Stack<Integer> pioche, ArrayList<ArrayList<String>> allist) {
		ArrayList<Integer> tb_num_pioche = new ArrayList<Integer>();
		for (int i=0;  i<nombre; i++) {
			int n = pioche.pop();
			//System.out.println(n);
			tb_num_pioche.add(n+1);
			//System.out.println(allist.get(n+1));
				
		}
		return tb_num_pioche;
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


}



