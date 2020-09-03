package my.project;

import java.util.LinkedList;
import java.util.List;

/**
 * Bu sýnýf bir kelime ile ilgili bilgileri içerir.
 * 
 * @author belkýs
 * 
 */
public class Entry {

	/** Kelime */
	private String word;
	/** Kelimenin tanýmý */
	private String description;
	/** Kelimenin uygun olmadýðý locationlarýn listesi */
	private List<Location> inappropriate;
	/** Kelimenin yerleþtirildiði location */
	private Location location;

	/**
	 * Constructor
	 * 
	 * @param word
	 * @param description
	 */
	public Entry(String word, String description) {
		this.word = word;
		this.description = description;
		this.inappropriate = new LinkedList<Location>();
	}

	/**
	 * Bu fonksiyon iki Entry yi karþýlaþtýrýp eþit olup olamdýðýný belirler.
	 * 
	 */
	@Override
	public boolean equals(Object entry) {
		/** Alýnan nesne Entry ye cast edilir. */
		Entry template = (Entry) entry;
		/** Kelimelerin eþit olup olmadýðý kontrol edilir. */
		if (this.getWord().equals(template.getWord())) {
			/** Tanýmlarýnýn eþit olup olmadýðý kontrol edilir . */
			if (this.getDescription().equals(template.getDescription())) {
				/** Bunlar eþitse true döndürülür. */
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Location atama
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Kelimenin locationýný döndürür.
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Kelimeyi döndürür.
	 * 
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Kelime tanýmýný döndürür.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Kelime atama.
	 * 
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Kelime tanýmý atama
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Listeyi döndürür.
	 * 
	 * @return inappropriate
	 */
	public List<Location> getList() {
		return inappropriate;
	}
}
