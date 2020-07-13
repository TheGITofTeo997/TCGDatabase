package it.unibs.db.tcg.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.unibs.db.tcg.controller.*;

@SuppressWarnings("unused")
public class TCGMain {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Controller controller = new Controller();
		controller.buildFrame();
	}
}
