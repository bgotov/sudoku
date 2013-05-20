package sudoku;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;

import javax.swing.JPanel;

public class Border extends JPanel{
	
	private Button initialise; 
	private Grid grid;
	private Verification verify;
	
	public Border(){
//		setLayout();
		setLayout (new BorderLayout());
		
		grid = new Grid();
		verify = new Verification();
		add(grid, BorderLayout.CENTER);
		
		add(verify, BorderLayout.SOUTH);
//		add(grid1, BorderLayout.CENTER);
		
		
		
	}
	

}
