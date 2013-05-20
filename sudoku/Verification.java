package sudoku;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sudoku.Grid.STextField;

public class Verification extends JPanel {
	public static JLabel timer;
	
	public Verification() {
		String str = Grid.arrTextField[1][1].getText();
		setLayout(new FlowLayout());

		// Grid.arrTextField[1][1].getXx();
		JButton initialise = new JButton("Start new / Initialise");
		JButton verify = new JButton("Verify");
		JButton removeRed = new JButton("Remove red");
		timer = new JLabel("00:00:00");
		
		verify.addActionListener(new VerifyActionListener());
		initialise.addActionListener(new IniActionListener());
		removeRed.addActionListener(new UndoActionListener());
		
		add(initialise);
		add(verify);
		add(removeRed);
		add(timer);
		Timer tTimer = new Timer();
		Thread t1 = new  Thread(tTimer);
		t1.start();
		

		// verify.add
	}

	private class VerifyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			for (int i = 0; i < Grid.arrTextField.length; i++) {
				for (int j = 0; j < Grid.arrTextField[0].length; j++) {
					if(Grid.arrTextField[i][j].getBackground().equals(Color.LIGHT_GRAY)){
						continue;
					}
					if(!Grid.isDigit(Grid.arrTextField[i][j].getText())){
						Grid.arrTextField[i][j].setBackground(Color.RED);
						continue;
					}
					if (!(Grid.validRow(Grid.arrTextField[i][j])&&
						Grid.validCol(Grid.arrTextField[i][j])&& 
						Grid.validSqare(Grid.arrTextField[i][j])&&
						Grid.arrTextField[i][j].getText().length()==1
						)) {
						Grid.arrTextField[i][j].setBackground(Color.RED);
					}
					
					
				}
			}
		}
		
		
	}
//Listener за бутона за инициализация
	private class IniActionListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// изчистваме масива, за да го попълниме на ново при инициализация
			for (int i = 0; i < Grid.arrTextField.length; i++) {
				for (int j = 0; j < Grid.arrTextField[0].length; j++) {						
						Grid.arrTextField[i][j].setBackground(Color.WHITE);	
						Grid.arrTextField[i][j].setName("");
						Grid.arrTextField[i][j].setText("");		
				}
			}
			
			int r1 = (int) (9 * Math.random());
			int r2 = (int) (9 * Math.random());
			int r3 = (int) (1 + 9 * Math.random());

			// grid.arr[r1][r2].setText(r3 + "");
			//Grid.arrTextField[r1][r2].setText(r3 + "");
			for (int i = 0; i < 30; i++) {

				// int valid = 1;
				// grid.arr[r1][r2].setText(1 + "");
				for (int j = 1; j < 10; j++) {

					r1 = (int) (9 * Math.random());
					r2 = (int) (9 * Math.random());
					//Grid.arrTextField[r1][r2].setText(j + "");
					Grid.arrTextField[r1][r2].setText(((int)(1+9 * Math.random())) + "");
					// r1 = (int) ( 8 * Math.random());
					// r2 = (int) ( 8 * Math.random());
					if ((Grid.validCol(Grid.arrTextField[r1][r2])
							&& Grid.validRow(Grid.arrTextField[r1][r2]) && Grid
								.validSqare(Grid.arrTextField[r1][r2]))) 
								{
						Grid.arrTextField[r1][r2].setBackground(Color.LIGHT_GRAY);
						break;
					} else {
						
						Grid.arrTextField[r1][r2].setText("");
						Grid.arrTextField[r1][r2].setBackground(Color.WHITE);
						
					}
				}

			}

		}

	}
//Listener за бутона за премахване на червения цвят от празните полета
	public class UndoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < Grid.arrTextField.length; i++) {
				for (int j = 0; j < Grid.arrTextField[0].length; j++) {
					if (!(Grid.validRow(Grid.arrTextField[i][j])
							&& Grid.validCol(Grid.arrTextField[i][j]) 
							&& Grid.validSqare(Grid.arrTextField[i][j]))
								&&
								!Grid.arrTextField[i][j].getBackground().equals(Color.LIGHT_GRAY)&&
								Grid.arrTextField[i][j].getBackground().equals(Color.RED)
								
							) 
					{	
						
						Grid.arrTextField[i][j]
								.setBackground(Grid.arrTextField[i][j]
										.getBackground().WHITE);
						
					} 
					
				}
			}
		}
		
	}

}
