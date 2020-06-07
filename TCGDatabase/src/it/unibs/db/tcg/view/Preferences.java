package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;

import it.unibs.db.tcg.model.Strings;

public class Preferences {

	private static Font myFont = new Font(Strings.DEFAULT_FONT, 0, Strings.DEFAULT_SIZE_FONT);
	private static Color backgroundColor = Strings.DEFAULT_BACKGROUND_COLOR;
	private static Color secondaryBackgroundColor = Strings.DEFAULT_SECONDARY_BACKGROUND_COLOR;
	private static Color foregroundColor = Strings.DEFAULT_FOREGROUND;

	public static Font getFont() {
		return myFont;
	}

	public static void setFont(Font font) {
		myFont = font;
	}

	public static Color getBackgroundColor() {
		return backgroundColor;
	}

	public static void setBackgroundColor(Color backgroundColor) {
		Preferences.backgroundColor = backgroundColor;
	}

	public static Color getSecondaryBackgroundColor() {
		return secondaryBackgroundColor;
	}

	public static void setSecondaryBackgroundColor(Color secondaryBackgroundColor) {
		Preferences.secondaryBackgroundColor = secondaryBackgroundColor;
	}

	public static Color getForegroundColor() {
		return foregroundColor;
	}

	public static void setForegroundColor(Color foregroundColor) {
		Preferences.foregroundColor = foregroundColor;
	}

}
