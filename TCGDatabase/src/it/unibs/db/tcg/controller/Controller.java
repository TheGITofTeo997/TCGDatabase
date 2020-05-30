package it.unibs.db.tcg.controller;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		logPan.setBounds(0,0,800,600);
		frame.getContentPane().add(logPan);
		logPan.addHomeListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(logPan.getLoginField().equals(null) || !model.isUserExistant(logPan.getLoginField()))
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
		homePan.setBounds(0,0,800,600);
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
	}

	public void drawAccountPanel(Utente user) {
		acPan = new AccountPanel();
		acPan.setBounds(0,0,800,600);
		frame.getContentPane().add(acPan);
		acPan.setNickname(user.getNickname());
		acPan.setMail(user.getMail());
		acPan.setAvatar(user.getAvatar());
		acPan.setUserName(user.getNomeUtente());
		acPan.setRegistrationDate(user.getDataRegistrazione().toString());
		acPan.setCollections(user.getListModel());
		
		
		acPan.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = user.getListModel().get(acPan.getListSelectedIndex());
					Collezione c = user.getCollezioneByNome(collection);
					//drawCollectionPanel(user, c);
				}
			}
        });
		
	}
	

	
	

}
