package it.unibs.db.tcg.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.*;
import it.unibs.db.tcg.view.*;

public class Controller {

	private ModelGod model;

	/* View components */
	private JFrame frame;
	private AccountPanel acPan = null;
	private HomePanel homePan = null;
	private LoginPanel logPan = null;
	private SearchPanel srcPan = null;
	private CartaPanel carPan = null;
	private EditPanel edPan = null;

	public Controller() {
		model = new ModelGod();
	}

	public void buildFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame("TCG Database");
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
					drawLoginPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
					drawHomePanel(model.getUser(logPan.getLoginField()));
				}
			}
		});
	}

	public void drawHomePanel(Utente user) {
		homePan = new HomePanel();
		homePan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(homePan);

		homePan.setAvatar(user.getAvatar());
		homePan.setNickname(user.getNickname());

		homePan.addAccountListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePan.setVisible(false);
				drawAccountPanel(user);
			}
		});
		
		homePan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(homePan.showConfirmDialog() == 0) {
					homePan.setVisible(false);
					drawLoginPanel();
				}
			}
		});
	}

	public void drawAccountPanel(Utente user) {
		acPan = new AccountPanel();
		acPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(acPan);
		acPan.setNickname(user.getNickname());
		acPan.setMail(user.getMail());
		acPan.setAvatar(user.getAvatar());
		acPan.setUserName(user.getNomeUtente());
		acPan.setRegistrationDate(user.getDataRegistrazione().toString());
		acPan.setCollections(user.getDefaultListModelCollections());

		acPan.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = user.getDefaultListModelCollections().get(acPan.getListSelectedIndex());
					Collezione c = new Collezione(collection);
					//c.setCards(user.getDefaultListModelCards);
					drawCardsPanel("titolo", c.getCardsListName());
				}
			}
		});

		acPan.addEditListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acPan.setVisible(false);
				drawEditPanel(user);
			}
		});
		
		acPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acPan.setVisible(false);
				drawHomePanel(user);
			}
		});

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
				//check result consistency, add new name then call drawEditPanel(user);
				user.setNomeUtente(result);
				drawEditPanel(user);
			}
		});
		
		edPan.addEditMailListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
			}
		});
		
		edPan.addEditAvatarListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = edPan.showEditPopup();
			}
		});
		
		edPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edPan.setVisible(false);
				drawAccountPanel(user);
			}
		});
	}
	
	public void drawCardsPanel(String title, List<String> cardsName) {
		//titolo da mostrare sopra 
		//lista di carte da mostrare
		
	}

}
