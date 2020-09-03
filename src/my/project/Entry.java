package my.project;

import java.util.LinkedList;
import java.util.List;

/**
 * Bu s�n�f bir kelime ile ilgili bilgileri i�erir.
 * 
 * @author belk�s
 * 
 */
public class Entry {

	/** Kelime */
	private String word;
	/** Kelimenin tan�m� */
	private String description;
	/** Kelimenin uygun olmad��� locationlar�n listesi */
	private List<Location> inappropriate;
	/** Kelimenin yerle�tirildi�i location */
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
	 * Bu fonksiyon iki Entry yi kar��la�t�r�p e�it olup olamd���n� belirler.
	 * 
	 */
	@Override
	public boolean equals(Object entry) {
		/** Al�nan nesne Entry ye cast edilir. */
		Entry template = (Entry) entry;
		/** Kelimelerin e�it olup olmad��� kontrol edilir. */
		if (this.getWord().equals(template.getWord())) {
			/** Tan�mlar�n�n e�it olup olmad��� kontrol edilir . */
			if (this.getDescription().equals(template.getDescription())) {
				/** Bunlar e�itse true d�nd�r�l�r. */
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
	 * Kelimenin location�n� d�nd�r�r.
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Kelimeyi d�nd�r�r.
	 * 
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Kelime tan�m�n� d�nd�r�r.
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
	 * Kelime tan�m� atama
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Listeyi d�nd�r�r.
	 * 
	 * @return inappropriate
	 */
	public List<Location> getList() {
		return inappropriate;
	}
}
