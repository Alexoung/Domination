import javax.swing.JFrame;

import javax.swing.JPanel;



import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



import javax.swing.JButton;



public class Fenetre extends JFrame {
	
	String name;
	JButton[][] listbutton;
	//JButton[][] tbbutton;

	public Fenetre(String name) {

		this.name = name;
		//this.tbbutton = tbbutton;
		this.setTitle("grille de " + name);

		this.setSize(700, 700);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);



		JPanel panel = new JPanel(new BorderLayout());

//		JPanel grid = new JPanel(new GridLayout(9,9));
//
//		JPanel left = new JPanel();
//
//		JPanel right = new JPanel();
//
//		panel.add(grid, BorderLayout.CENTER);
//
//
//
//		panel.add(right, BorderLayout.EAST);
//
//		right.setBackground(Color.RED);
//
//		panel.add(left, BorderLayout.WEST);
//
//		right.setBackground(Color.CYAN);



		this.setContentPane(panel);

		panel.setLayout(new GridLayout(9, 9));

		JButton[][] listbutton = new JButton[9][9];
		this.listbutton=listbutton;

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				listbutton[i][j] = new JButton();

				if (j == 4 && i == 4) {

					listbutton[4][4].setText("roi");

					listbutton[4][4].setName("roi");
					listbutton[4][4].setBackground(Color.ORANGE);
					listbutton[4][4].setOpaque(true);
					listbutton[4][4].setBorderPainted(false);
					

				} else {

					listbutton[i][j].setName("b_" + (i+1) + '_' + (j+1));

					listbutton[i][j].setText("b_" + (i+1) + '_' + (j+1));

				}

				listbutton[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						JButton eventSource = (JButton) e.getSource();

						String buttonName = eventSource.getName();

						String[] parts = buttonName.split("_");

						int i = Integer.parseInt(parts[1]);

						int j = Integer.parseInt(parts[2]);

						System.out.print(Fenetre.retour(i, j)[0]);

						System.out.println(Fenetre.retour(i, j)[1]);
						
//						listbutton[i][j].setBackground(Color.RED);
//						listbutton[i][j].setOpaque(true);
//						listbutton[i][j].setBorderPainted(false);

						// System.out.println("i : "+i+", j:"+j);

					}

				});

				panel.add(listbutton[i][j]);

			}

		}
		

	}





	public JButton[][] getListbutton() {
		return listbutton;
	}





	public void setListbutton(JButton[][] listbutton) {
		this.listbutton = listbutton;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public static int[] retour(int i, int j) {
		int[] tb = { i, j };

		return tb;

	}
	
	public void color_fenetre(Joueur joueur) {
		for (int i = 0; i<9; i++) {
			for (int j = 0; j<9;j++) {
				joueur.getFen().colorier(joueur.getFen().getListbutton()[i][j], joueur.getGrille()[i][j][0]);
				
				if(joueur.getGrille()[i][j][1].equals("0")==false) {
				joueur.getFen().getListbutton()[i][j].setText(joueur.getGrille()[i][j][1]);
			}
				
	}
	}
	}
	
	public void colorier ( JButton buttonname, String type) {
		final Color DARKGREEN = Color.decode("#2CB705");
		if (type.equals("Champs")) {
			buttonname.setBackground(Color.YELLOW);
			buttonname.setOpaque(true);
			buttonname.setBorderPainted(false);
			System.out.println("couleur champs");
		}
		if (type.equals("Mine")) {
			buttonname.setBackground(Color.GRAY);
			buttonname.setOpaque(true);
			buttonname.setBorderPainted(false);
			System.out.println("couleur champs");
		}
		if (type.equals("Prairie")) {
			buttonname.setBackground(Color.GREEN);
			buttonname.setOpaque(true);
			buttonname.setBorderPainted(false);
			System.out.println("couleur champs");
		}
		if (type.equals("Montagne")) {
			buttonname.setBackground(Color. BLACK);
			buttonname.setOpaque(true);
			buttonname.setBorderPainted(false);
			System.out.println("couleur champs");
		}
		if (type.equals("Mer")) {
			buttonname.setBackground(Color.BLUE);
			buttonname.setOpaque(true);
			buttonname.setBorderPainted(false);
			System.out.println("couleur champs");
		}
				
		if (type.equals("Foret")) {
			buttonname.setBackground(DARKGREEN);
			buttonname.setOpaque(true);
			buttonname.setBorderPainted(false);
			System.out.println("couleur champs");
		}
	}
		
	
}

