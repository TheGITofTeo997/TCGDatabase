package it.unibs.db.tcg.controller;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import it.unibs.db.tcg.model.ConnectorService;
import it.unibs.db.tcg.model.Strings;

public class Controller {

	protected ConnectorService connectorService;

	private LoginController loginController;

	private JFrame frame;

	public Controller() {
		connectorService = new ConnectorService();
	}

	public void buildFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame(Strings.FRAME_TITLE);
					frame.setResizable(false);
					frame.setBounds(0, 0, 800, 600);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							System.exit(0);
						}
					});
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon("resources//icon//icon.png").getImage());
					loginController = new LoginController(frame);
					loginController.drawLoginPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
