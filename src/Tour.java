import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Tour {
	ArrayList<Integer> current_order;
	ArrayList<Integer> next_order;
	ArrayList<Integer> last_pioche;
	
	public Tour(ArrayList<Integer> current_order, ArrayList<Integer> next_order, ArrayList<Integer> last_pioche) {
		this.current_order = current_order;
		this.next_order = next_order;
		this.last_pioche = last_pioche;
	}

	public ArrayList<Integer> getCurrent_order() {
		return current_order;
	}

	public void setCurrent_order(ArrayList<Integer> current_order) {
		this.current_order = current_order;
	}

	public ArrayList<Integer> getNext_order() {
		return next_order;
	}

	public void setNext_order(ArrayList<Integer> next_order) {
		this.next_order = next_order;
	}

	public ArrayList<Integer> getLast_pioche() {
		return last_pioche;
	}

	public void setLast_pioche(ArrayList<Integer> last_pioche) {
		this.last_pioche = last_pioche;
	}

	public static ArrayList<Integer> ordre_debut(int nbj){
		ArrayList<Integer> ordre = new ArrayList<Integer>();
		Random rand = new Random();
		//System.out.println(random.nextInt(nbj));
		if (nbj==2) {
			while(ordre.size()!=4) {
				int next = rand.nextInt(nbj);
				if (ordre.contains(next)==false) {
					ordre.add(next);
					ordre.add(next);
					
				}
			}
		}

			
		else{
			while(ordre.size()!=nbj) {
			int next = rand.nextInt(nbj);
			if (ordre.contains(next)==false) {
				ordre.add(next);
				if(nbj==2) {
					ordre.add(next);
				}
			}
		}
		}
		//}
		return ordre;
	}
	
	//public static Stack<Integer> next_order(){}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
