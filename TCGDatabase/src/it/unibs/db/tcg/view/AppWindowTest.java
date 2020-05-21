package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;



public class AppWindowTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindowTest window = new AppWindowTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindowTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AccountPanel ap = new AccountPanel();
		LoginPanel lp = new LoginPanel();
		HomePanel hp = new HomePanel();
		
		
		ap.setBounds(0, 0, 800, 600);
		ap.setNickname("Giakomyno12");
		ap.setUserName("Giacomino");
		ap.setMail("giacom@mail.it");
		ap.setRegistrationDate("12/12/12");
		lp.setBounds(0,0, 800, 600);
		
		//frame.add(ap); //guarda account panel
		//frame.add(lp); //guarda login panel
		frame.add(hp);
		ap.setNickname("giuseppi");
		
		
		frame.setVisible(true);
	}

}
