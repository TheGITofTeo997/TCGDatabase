package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import it.unibs.db.tcg.model.ModelGod;
import it.unibs.db.tcg.model.Strings;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.LoginPanel;
import it.unibs.db.tcg.view.RegistrationPanel;

public class LoginController extends Controller {

	// private ModelGod model;



	private LoginPanel logPan;
	private RegistrationPanel regPan;
	
	private JFrame frame;
	
	public LoginController(JFrame frame) {
		this.frame = frame;
	}
	
	public void drawLoginPanel() {
		logPan = new LoginPanel();
		logPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(logPan);
		logPan.addHomeListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logPan.getLoginField().equals(null) || !model.isUserExistant(logPan.getLoginField()))
					logPan.showErrorPopup();
				else {
					logPan.setVisible(false);
					HomeController homeController = new HomeController(frame);
					homeController.drawHomePanel(logPan.getLoginField());
				}
			}
		});
		logPan.addRegistrationListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logPan.setVisible(false);
				drawRegistrationPanel();
			}
		});
	}

	public void drawRegistrationPanel() {
		regPan = new RegistrationPanel();
		regPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(regPan);

		regPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				regPan.setVisible(false);
				drawLoginPanel();
			}
		});

		regPan.addRegisterListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nickname = regPan.getNicknameText();
				if (nickname.length() == 0 || model.isUserExistant(nickname)) {
					regPan.showNicknameErrorPopup();
				} else {
					Utente user = new Utente();
					String name = regPan.getNameText();
					String mail = regPan.getMailText();
					Icon icon = regPan.getAvatarImage();
					if (!name.matches(Strings.USERNAME_REGEX)) {
						regPan.showNameErrorPopup();
					} else if (!mail.matches(Strings.MAIL_REGEX)) {
						regPan.showMailErrorPopup();
					} else {
						user.setNickname(nickname);
						user.setNomeUtente(name);
						user.setMail(mail);
						user.setAvatar(((ImageIcon) icon));
						model.createUser(user);
						regPan.setVisible(false);
						AccountController accountController = new AccountController(frame);
						accountController.drawAccountPanel(user.getNickname());
					}
				}
			}
		});

	}
}
