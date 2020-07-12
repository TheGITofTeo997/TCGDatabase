package it.unibs.db.tcg.model.util;

import java.awt.Desktop;
import java.io.File;


public class FileLoader {
	
	public static void openGuida() {
		try {
			File f = new File("data//GuidaUtenteTCGDatabase.pdf");
			if (f.exists()) {
				if (Desktop.isDesktopSupported())
					Desktop.getDesktop().open(f);
				else
					System.out.println("Impossibile trovare il file di guida");
			} 
			else
				System.out.println("Impossibile trovare il file di guida");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
