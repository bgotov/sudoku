package sudoku;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Grid extends JPanel {

	static STextField[][] arrTextField = new STextField[9][9];
	Color currColor;
	public Grid() {
		GridLayout layout = new GridLayout(9, 9);
		setLayout(layout);
		// Попълваме масива с елементи
		for (int i = 0; i < arrTextField.length; i++) {
			for (int j = 0; j < arrTextField[0].length; j++) {
				arrTextField[i][j] = new STextField(i, j);
				

			}
		}

		// Променяме елементите за инициализацията
		arrTextField[0][2].setText("3");
		arrTextField[0][5].setText("2");
		arrTextField[0][7].setText("7");
		arrTextField[1][3].setText("4");
		arrTextField[1][8].setText("9");
		arrTextField[2][0].setText("6");
		arrTextField[2][5].setText("9");
		arrTextField[2][6].setText("2");
		arrTextField[2][7].setText("1");
		arrTextField[3][1].setText("5");
		arrTextField[3][4].setText("8");
		arrTextField[3][7].setText("3");
		arrTextField[4][3].setText("1");
		arrTextField[4][5].setText("5");
		arrTextField[4][6].setText("8");
		arrTextField[4][8].setText("6");
		arrTextField[5][0].setText("8");
		arrTextField[5][2].setText("6");
		arrTextField[5][4].setText("4");
		arrTextField[6][2].setText("2");
		arrTextField[6][4].setText("5");
		arrTextField[7][0].setText("7");
		arrTextField[7][2].setText("8");
		arrTextField[7][3].setText("2");
		arrTextField[8][1].setText("9");
		arrTextField[8][4].setText("3");
		arrTextField[8][8].setText("1");
		

		// Добавяме елементите към панела
		for (int i = 0; i < arrTextField.length; i++) {
			for (int j = 0; j < arrTextField[0].length; j++) {
				if (!arrTextField[i][j].getText().equals("")) {

					arrTextField[i][j].setBackground(this.getBackground().LIGHT_GRAY);
					arrTextField[i][j].setEditable(false);
					arrTextField[i][j].addMouseListener(new MouseListenerText());
					add(arrTextField[i][j]);
				} else {
					arrTextField[i][j].setBackground(getBackground().WHITE);
					arrTextField[i][j].setEditable(false);
					
					arrTextField[i][j]
							.addMouseListener(new MouseListenerText());
					add(arrTextField[i][j]);
				}
			}
		}

	}

	// Verify methods
	static boolean validRow(STextField t) {
		for (int i = 0; i < 9; i++) {
			// vzima texta convertira go v int i proveriava ima li takova
			// chislo v reda
			if ((t.getText() + "")
					.equals((arrTextField[t.getXx()][i].getText()))) {
				if (t.getYy() == i)
					continue;
				return false;
			}
		}
		return true;

	}

	static boolean validCol(STextField t) {
		for (int i = 0; i < 9; i++) {
			// vzima texta convertira go v int i proveriava ima li takova
			// chislo v kolonata

			if ((t.getText() + "").equals(((arrTextField[i][t.getYy()])
					.getText()))) {
				if (t.getXx() == i)
					continue;
				return false;
			}
		}
		return true;
	}

	static boolean validSqare(STextField t) {
		int i1;
		int j1;
		i1 = t.getXx() / 3;
		i1 = i1 * 3;
		j1 = t.getYy() / 3;
		j1 = j1 * 3;
		for (int i = i1; i < i1 + 3; i++) {
			for (int j = j1; j < j1 + 3; j++) {
				if (t.getXx() == i && t.getYy() == j)

					continue;
				if (t.getText().equals(arrTextField[i][j].getText())) {

					return false;
				}
			}
		}

		return true;
	}
	
	static boolean isDigit(String str){
		
		if(str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")
				||str.equals("5")||str.equals("6")||str.equals("7")||str.equals("8")||str.equals("9")){
			return true;
		}
		return false;
		
		
	}
//	private void borderInit(){
//		arrTextField[0][3].set(Border.);
//		arrTextField[0][4].setBorder("2");
//		arrTextField[0][5].setBorder("7");
//		arrTextField[1][3].setBorder("4");
//		arrTextField[1][4].setBorder("9");
//		arrTextField[1][5].setBorder("6");
//		arrTextField[2][3].setBorder("9");
//		arrTextField[2][4].setBorder("2");
//		arrTextField[2][5].setBorder("1");
//		arrTextField[3][0].setBorder("5");
//		arrTextField[3][1].setBorder("8");
//		arrTextField[3][2].setBorder("3");
//		arrTextField[4][0].setBorder("1");
//		arrTextField[4][1].setBorder("5");
//		arrTextField[4][2].setBorder("8");
//		arrTextField[5][0].setBorder("6");
//		arrTextField[5][1].setBorder("8");
//		arrTextField[5][2].setBorder("6");
//		arrTextField[6][3].setBorder("4");
//		arrTextField[6][4].setBorder("2");
//		arrTextField[6][5].setBorder("5");
//		arrTextField[3][6].setBorder("7");
//		arrTextField[3][7].setBorder("8");
//		arrTextField[3][8].setBorder("2");
//		arrTextField[4][6].setBorder("9");
//		arrTextField[4][7].setBorder("3");
//		arrTextField[4][8].setBorder("1");
//		arrTextField[5][6].setBorder("6");
//		arrTextField[5][7].setBorder("4");
//		arrTextField[5][8].setBorder("4");
//			}

	// //////////////////////////////////////////////////////////////////////////////
	class MouseListenerText implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			JTextField digit = (JTextField) e.getSource();
			if(digit.getBackground().equals(Color.LIGHT_GRAY)){
				digit.setEditable(false);
			}else{
			digit.setBackground(Color.ORANGE);}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			STextField digit = (STextField) e.getSource();
			
			if(digit.getBackground().equals(Color.LIGHT_GRAY)){
				digit.setEditable(false);
			}else if(digit.getBackground().equals(Color.RED)){
				digit.setEditable(true);
			}
			else{
			digit.setBackground(getBackground().YELLOW);
			digit.setEditable(true);}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			STextField digit = (STextField) e.getSource();
			if(digit.getBackground().equals(Color.LIGHT_GRAY)){
				digit.setEditable(false);
			}else if(digit.getBackground().equals(Color.RED)){
				digit.setEditable(false);
			}
			else{
			digit.setBackground(Color.WHITE);
			digit.setEditable(false);
			}
		}
	}

	// ////////////////////////////////////////////////////////////////////////
	public class TextActionListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			JTextField digit = (JTextField) ev.getSource();
			digit.setBackground(getBackground().YELLOW);

		}
	}

	// ////////////////////////////////////////////////////////////////////////
	protected class KeyListenerSudoku implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			JTextField digit = (JTextField) e.getSource();
			digit.setBackground(getBackground().GREEN);
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}

	class STextField extends JTextField {

		private static final long serialVersionUID = 1L;
		private int xx;
		private int yy;

		public STextField(int xx, int yy) {
			super();

			this.xx = xx;
			this.yy = yy;

		}

		public int getXx() {
			return xx;
		}

		public int getYy() {
			return yy;
		}

	}

}
