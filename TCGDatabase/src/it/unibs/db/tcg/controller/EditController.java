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

public class EditController extends Controller{
	
	private EditPanel edPan;
	
private JFrame frame;
	
	public EditController(JFrame frame) {
		this.frame = frame;
	}
	
	public void drawEditPanel(Utente user) {
		edPan = new EditPanel();
		edPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(edPan);
		edPan.setNickname(user.getNickname());
		edPan.setUserName(user.getNomeUtente());
		edPan.setMail(user.getMail());
		edPan.setName(user.getNomeUtente());
		edPan.setAvatar(user.getAvatar());

		edPan.addEditNameListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
				if (result != null) {
					if (result.matches(Strings.USERNAME_REGEX) && result.length() > 2) {
						connectorService.updateUserName(user.getNickname(), result);
						user.setNomeUtente(result);
						edPan.setUserName(result);
						edPan.showCorrectPopup();
					} else
						edPan.showErrorPopup();
				}
			}
		});

		edPan.addEditMailListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
				if (result != null) {
					Pattern p = Pattern.compile(Strings.MAIL_REGEX, Pattern.CASE_INSENSITIVE);
					Matcher matcher = p.matcher(result);
					if (matcher.find()) {
						connectorService.updateMail(user.getNickname(), result);
						user.setMail(result);
						edPan.setMail(result);
						edPan.showCorrectPopup();
					} else
						edPan.showErrorPopup();
				}

			}
		});

		edPan.addEditAvatarListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = edPan.chooseAvatar();
				if (icon != null) {
					edPan.setAvatar(icon);
					user.setAvatar(icon);
					connectorService.updateAvatar(user.getNickname(), icon);
					edPan.showCorrectPopup();
				}

			}
		});

		edPan.addDeleteAvatarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (edPan.showConfirmPopup("Vuoi eliminare definitivamente l'avatar del profilo?")) {
					ImageIcon icon = new ImageIcon("resources//default_avatar.jpg");
					edPan.setAvatar(icon);
					user.setAvatar(icon);
					connectorService.updateAvatar(user.getNickname(), icon);
					edPan.showCorrectPopup();
				}
			}
		});
		
		edPan.addDeleteCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for (String collection : connectorService.getUserCollections(user.getNickname())) {
						listModel.addElement(collection);				
				}
				edPan.createCollectionListPopup(listModel);
				String selectedCollection = edPan.showCollectionsListPopup();
				if (selectedCollection != null) {
					if(edPan.showConfirmPopup("Sei sicuro di voler eliminare la collezione " + selectedCollection + " ?")) {
						connectorService.deleteCollection(user.getNickname(), selectedCollection);						
					}
				}
				edPan.setVisible(false);
				drawEditPanel(user);
			}
		});

		edPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edPan.setVisible(false);
				AccountController accountController = new AccountController(frame);
				accountController.drawAccountPanel(user.getNickname());
			}
		});
	}
}
