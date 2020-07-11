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
import it.unibs.db.tcg.model.util.LogWriter;
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
						LogWriter.write("Richiesta update username dell'utente " + user.getNickname() + ". Nuovo username: " + result);
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
						LogWriter.write("Richiesta update email dell'utente " + user.getNickname() + ". Nuova mail: " + result);
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
					LogWriter.write("Richiesta update avatar");
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
					LogWriter.write("Eliminazione dell'avatar attuale dell'utente, inserimento avatar di default");
					ImageIcon icon = new ImageIcon("resources//default_avatar.jpg");
					editPanel.setAvatar(icon);
					user.setAvatar(icon);
					connectorService.updateAvatar(user.getNickname(), icon);
					editPanel.showCorrectPopup();
				}
			}
		});
		
		editPanel.addEditCollectionNameListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for (String collection : connectorService.getUserCollections(user.getNickname())) {
					listModel.addElement(collection);
				}
				editPanel.createCollectionListPopup(listModel);
				String selectedCollection = editPanel.showCollectionsListPopup();
				if (selectedCollection != null) {
					String newCollectionName = editPanel.showEditPopup();
					if(newCollectionName != null) {
						LogWriter.write("Modifica del nome della collezione " + selectedCollection + ". Nuovo nome collezione: " + newCollectionName);
						user.getCollezioneByNome(selectedCollection).setNomeCollezione(newCollectionName);
						connectorService.updateCollectionName(newCollectionName, user.getNickname(), selectedCollection);
						editPanel.showCorrectPopup();
					}
				}
				editPanel.setVisible(false);
				drawEditPanel(user);
			}
		});
		
		editPanel.addEditVisibilityCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for (String collection : connectorService.getUserCollections(user.getNickname())) {
					listModel.addElement(collection);
				}
				editPanel.createCollectionListPopup(listModel);
				String selectedCollection = editPanel.showCollectionsListPopup();
				if (selectedCollection != null) {
					editPanel.showChangeVisibilityCollectionPopup();
					String visible = editPanel.getVisibileField();
					if(visible != null) {
						boolean flag;
						if(visible.equals("Visibile")) flag = true;
						else flag = false;
						LogWriter.write("Cambiamento visibilità della collezione " + selectedCollection);
						connectorService.updateCollectionVisibility(flag, user.getNickname(), selectedCollection);
						editPanel.showCorrectPopup();
					}
				}
				editPanel.setVisible(false);
				drawEditPanel(user);
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
						LogWriter.write("Cancellazione definitiva della collezione " + selectedCollection);
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
				LogWriter.write("Apertura accountPanel");
				AccountController accountController = new AccountController(frame);
				accountController.drawAccountPanel(user.getNickname());
			}
		});
	}
}
