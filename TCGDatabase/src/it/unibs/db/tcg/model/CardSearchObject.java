package it.unibs.db.tcg.model;

import java.util.List;

public class CardSearchObject {
	String cardName;
	String exp;
	String cardIllustrator;
	int lowerPSValue = 0;
	int upperPSValue = 500;
	int lowerValueBarValue = 0;
	int upperValueBarValue = 1000;
	List<String> cardType;
	List<String> energyType;
	List<String> rarityType;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getCardIllustrator() {
		return cardIllustrator;
	}

	public void setCardIllustrator(String cardIllustrator) {
		this.cardIllustrator = cardIllustrator;
	}

	public int getLowerPSValue() {
		return lowerPSValue;
	}

	public void setLowerPSValue(int lowerPSValue) {
		this.lowerPSValue = lowerPSValue;
	}

	public int getUpperPSValue() {
		return upperPSValue;
	}

	public void setUpperPSValue(int upperPSValue) {
		this.upperPSValue = upperPSValue;
	}

	public int getLowerValueBarValue() {
		return lowerValueBarValue;
	}

	public void setLowerValueBarValue(int lowerValueBarValue) {
		this.lowerValueBarValue = lowerValueBarValue;
	}

	public int getUpperValueBarValue() {
		return upperValueBarValue;
	}

	public void setUpperValueBarValue(int upperValueBarValue) {
		this.upperValueBarValue = upperValueBarValue;
	}

	public List<String> getCardType() {
		return cardType;
	}

	public void setCardType(List<String> cardType) {
		this.cardType = cardType;
	}

	public List<String> getEnergyType() {
		return energyType;
	}

	public void setEnergyType(List<String> energyType) {
		this.energyType = energyType;
	}

	public List<String> getRarityType() {
		return rarityType;
	}

	public void setRarityType(List<String> rarityType) {
		this.rarityType = rarityType;
	}
	
	public boolean hasCardName() {
		return cardName.length() != 0;
	}
	
	public boolean hasExp() {
		return exp.length() != 0;
	}
	
	public boolean hasCardIllustrator() {
		return cardIllustrator.length() != 0;
	}
	
	public boolean hasCardType() {
		return cardType.size() != 0;
	}
	
	public boolean hasEnergyType() {
		return energyType.size() != 0;
	}
	
	public boolean hasRarityType() {
		return rarityType.size() != 0;
	}
}
