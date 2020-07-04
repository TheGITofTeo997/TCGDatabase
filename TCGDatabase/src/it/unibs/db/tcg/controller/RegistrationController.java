package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import it.unibs.db.tcg.model.Strings;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.RegistrationPanel;

public class RegistrationController extends Controller {
	private RegistrationPanel registrationPanel;

	private JFrame frame;

	public RegistrationController(JFrame frame) {
		this.frame = frame;
	}

	public void drawRegistrationPanel() {
		registrationPanel = new RegistrationPanel();
		registrationPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(registrationPanel);

		registrationPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrationPanel.setVisible(false);
				LoginController loginController = new LoginController(frame);
				loginController.drawLoginPanel();
			}
		});

		registrationPanel.addRegisterListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nickname = registrationPanel.getNicknameText();
				if (nickname.length() == 0 || connectorService.isUserExistant(nickname)) {
					registrationPanel.showNicknameErrorPopup();
				} else {
					Utente user = new Utente();
					String name = registrationPanel.getNameText();
					String mail = registrationPanel.getMailText();
					Icon icon = registrationPanel.getAvatarImage();
					if (!name.matches(Strings.USERNAME_REGEX)) {
						registrationPanel.showNameErrorPopup();
					} else if (!mail.matches(Strings.MAIL_REGEX)) {
						registrationPanel.showMailErrorPopup();
					} else {
						user.setNickname(nickname);
						user.setNomeUtente(name);
						user.setMail(mail);
						user.setAvatar(((ImageIcon) icon));
						connectorService.createUser(user);
						registrationPanel.setVisible(false);
						AccountController accountController = new AccountController(frame);
						accountController.drawAccountPanel(user.getNickname());
					}
				}
			}
		});

	}
}
