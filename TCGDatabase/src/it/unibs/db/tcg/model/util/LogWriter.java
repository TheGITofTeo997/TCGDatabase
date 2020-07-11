package it.unibs.db.tcg.model.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LogWriter {
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static void write(String toWrite) {
		Date date = new Date();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("log" + System.getProperty("file.separator") + "log.txt", true))) {
			bw.write("[" + dateFormat.format(date) + "] "+ toWrite + "\n");
		} 
		catch (IOException e) {  
			e.printStackTrace();
		}
	}
}
