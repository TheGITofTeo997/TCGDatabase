package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;



public class ApplicationFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -773384933562082684L;
	private JFrame frame;
	
	
	
	
	public void showFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFrame window = new ApplicationFrame();
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
	public ApplicationFrame() {
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
		ap.setNickname("giuseppi");
		
		
		frame.setVisible(true);
	}

}
