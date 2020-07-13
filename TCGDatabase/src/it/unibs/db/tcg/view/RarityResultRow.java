package it.unibs.db.tcg.view;

public class RarityResultRow {
	private String rarity;
	private int count;
	
	public RarityResultRow(String rarity, int count) {
		this.rarity = rarity;
		this.count = count;
	}

	public String getRarity() {
		return rarity;
	}
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	
}
