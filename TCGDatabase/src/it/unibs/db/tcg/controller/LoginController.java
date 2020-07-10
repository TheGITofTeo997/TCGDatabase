package it.unibs.db.tcg.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingWorker;


import it.unibs.db.tcg.view.LoginPanel;


public class LoginController extends Controller {

	private LoginPanel loginPanel;

	private JFrame frame;

	public LoginController(JFrame frame) {
		this.frame = frame;
	}

	public void drawLoginPanel() {
		loginPanel = new LoginPanel();
		loginPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(loginPanel);
		loginPanel.addHomeListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginPanel.getLoginField().equals(null)
						|| !connectorService.isUserExistant(loginPanel.getLoginField()))
					loginPanel.showErrorPopup();
				else {
					loginPanel.setVisible(false);
					HomeController homeController = new HomeController(frame);
					homeController.drawHomePanel(loginPanel.getLoginField());
				}
			}
		});

		loginPanel.addRegistrationListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				RegistrationController registrationController = new RegistrationController(frame);
				registrationController.drawRegistrationPanel();
			}
		});

		loginPanel.addRefreshDatabaseStatusListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkDatabaseStatus();
			}
		});

		checkDatabaseStatus();
	}
	
	private void checkDatabaseStatus() {
		SwingWorker<Void, Void> backgroundThread1 = new SwingWorker<Void, Void>() {
			boolean flag;

			@Override
			protected Void doInBackground() throws Exception {
				loginPanel.showWaitingDatabadeConnection();
				flag = connectorService.isReachable();
				return null;
			}

			@Override
			protected void done() {
				loginPanel.setDatabaseStatus(flag);
				loginPanel.setBtnLoginEnabled(flag);
				loginPanel.setBtnRegisterEnabled(flag);
			};
		};
		backgroundThread1.execute();
	}

}
