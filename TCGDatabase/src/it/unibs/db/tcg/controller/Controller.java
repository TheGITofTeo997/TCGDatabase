package it.unibs.db.tcg.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.*;
import it.unibs.db.tcg.view.*;

public class Controller {
	
	private ModelGod model;
	
	/* View components */
	private ApplicationFrame frame;
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
		frame = new ApplicationFrame();
		drawLoginPanel();
	}
	
	
	public void drawLoginPanel() {
		logPan = new LoginPanel();
		frame.getContentPane().add(logPan);
		
		logPan.addHomeListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(logPan.getLoginField().equals(null) && !model.isUserExistant(logPan.getLoginField()))
					logPan.showErrorPopup();
				else {
					logPan.setVisible(false);
					drawHomePanel();
				}
			}
		});
	} 
	
	public void drawHomePanel() {
		homePan = new HomePanel();
		frame.getContentPane().add(homePan);
		
		//homePan.setAvatar(user.getAvatar());
		//homePan.setNickname(user.getNickname());

		
		homePan.addAccountListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePan.setVisible(false);
				drawAccountPanel();		
			}
		});
	}

	public void drawAccountPanel() {
		acPan = new AccountPanel();
		
	}
	

	
	

}
