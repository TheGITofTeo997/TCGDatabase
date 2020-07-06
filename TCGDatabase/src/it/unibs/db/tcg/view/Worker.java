package it.unibs.db.tcg.view;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

import it.unibs.db.tcg.model.ConnectorService;

public class Worker extends SwingWorker<Void, String> {
	private LoginPanel loginPanel;
	private ConnectorService c;
	private boolean flag;

	public Worker(LoginPanel loginPanel, ConnectorService c) {
		this.loginPanel = loginPanel;
		c = c;
	}

	@Override
	protected Void doInBackground() throws Exception {
		flag = c.isReachable();
		System.out.println(flag);
		return null;
	}
		 
	 protected void done() {
		loginPanel.setDatabaseStatus(flag);
	 }
	
}
