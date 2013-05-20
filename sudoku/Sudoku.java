package sudoku;

import javax.swing.JFrame;



public class Sudoku {

	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Sudoku");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Grid panel = new Grid();
		Border border = new Border();
		frame.add(border);
		
		frame.setVisible(true);
		
	}

}
