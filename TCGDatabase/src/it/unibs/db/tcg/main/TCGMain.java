package it.unibs.db.tcg.main;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import it.unibs.db.tcg.controller.*;
import it.unibs.db.tcg.view.Preferences;

public class TCGMain {

	public static void main(String[] args) {
		Controller c = new Controller();
		c.buildFrame();
	}
}
