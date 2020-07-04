package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import it.unibs.db.tcg.model.Strings;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.EditPanel;

public class EditController extends Controller {

	private EditPanel editPanel;

	private JFrame frame;

	public EditController(JFrame frame) {
		this.frame = frame;
	}

	public void drawEditPanel(Utente user) {
		editPanel = new EditPanel();
		editPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(editPanel);
		editPanel.setNickname(user.getNickname());
		editPanel.setUserName(user.getNomeUtente());
		editPanel.setMail(user.getMail());
		editPanel.setName(user.getNomeUtente());
		editPanel.setAvatar(user.getAvatar());

		editPanel.addEditNameListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = editPanel.showEditPopup();
				if (result != null) {
					if (result.matches(Strings.USERNAME_REGEX) && result.length() > 2) {
						connectorService.updateUserName(user.getNickname(), result);
						user.setNomeUtente(result);
						editPanel.setUserName(result);
						editPanel.showCorrectPopup();
					} else
						editPanel.showErrorPopup();
				}
			}
		});

		editPanel.addEditMailListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = editPanel.showEditPopup();
				if (result != null) {
					Pattern p = Pattern.compile(Strings.MAIL_REGEX, Pattern.CASE_INSENSITIVE);
					Matcher matcher = p.matcher(result);
					if (matcher.find()) {
						connectorService.updateMail(user.getNickname(), result);
						user.setMail(result);
						editPanel.setMail(result);
						editPanel.showCorrectPopup();
					} else
						editPanel.showErrorPopup();
				}

			}
		});

		editPanel.addEditAvatarListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = editPanel.chooseAvatar();
				if (icon != null) {
					editPanel.setAvatar(icon);
					user.setAvatar(icon);
					connectorService.updateAvatar(user.getNickname(), icon);
					editPanel.showCorrectPopup();
				}

			}
		});

		editPanel.addDeleteAvatarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editPanel.showConfirmPopup("Vuoi eliminare definitivamente l'avatar del profilo?")) {
					ImageIcon icon = new ImageIcon("resources//default_avatar.jpg");
					editPanel.setAvatar(icon);
					user.setAvatar(icon);
					connectorService.updateAvatar(user.getNickname(), icon);
					editPanel.showCorrectPopup();
				}
			}
		});

		editPanel.addDeleteCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for (String collection : connectorService.getUserCollections(user.getNickname())) {
					listModel.addElement(collection);
				}
				editPanel.createCollectionListPopup(listModel);
				String selectedCollection = editPanel.showCollectionsListPopup();
				if (selectedCollection != null) {
					if (editPanel.showConfirmPopup(
							"Sei sicuro di voler eliminare la collezione " + selectedCollection + " ?")) {
						connectorService.deleteCollection(user.getNickname(), selectedCollection);
					}
				}
				editPanel.setVisible(false);
				drawEditPanel(user);
			}
		});

		editPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editPanel.setVisible(false);
				AccountController accountController = new AccountController(frame);
				accountController.drawAccountPanel(user.getNickname());
			}
		});
	}
}
