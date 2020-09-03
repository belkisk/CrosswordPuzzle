package my.project;

/**
 * Bu sýnýf yerleþtirilen bir kelimenin yer ve yön bilgilerini içerir.
 * 
 * @author belkýs
 * 
 */
public class Location {

	/** locationýn baþlangýç konumunun satýr indeksi. */
	private int firstRow;

	/** locationýn baþlangýç konumunun sütun indeksi. */
	private int firstColumn;

	/** locationýn bitiþ konumunun satýr indeksi. */
	private int lastRow;

	/** locationýn bitiþ indeksinin sütun indeksi. */
	private int lastColumn;

	/** locationýn yönünü belirler; dikeyse true, yataysa false. */
	private boolean isVertical;

	/**
	 * Aldýðý parametreleri fieldlara atayarak yeni bir location oluþturur.
	 * Constructor.
	 * 
	 * @param first_row
	 *            ilk satýr
	 * @param first_column
	 *            ilk sütun
	 * @param last_row
	 *            son satýr
	 * @param last_column
	 *            son sütun
	 * @param is_vertical
	 *            yön
	 */
	public Location(int first_row, int first_column, int last_row,
			int last_column, boolean is_vertical) {
		firstRow = first_row;
		firstColumn = first_column;
		lastRow = last_row;
		lastColumn = last_column;
		isVertical = is_vertical;
	}

	/**
	 * Ýlk satýra atama yapar.
	 * 
	 * @param first_row
	 *            ilk satýr
	 */
	public void setFirstRow(int first_row) {
		firstRow = first_row;
	}

	/**
	 * Ýlk sütuna atama yapar.
	 * 
	 * @param first_column
	 *            ilk sütun
	 */
	public void setFirstColumn(int first_column) {
		firstColumn = first_column;
	}

	/**
	 * Son satýra atama yapar.
	 * 
	 * @param last_row
	 *            son satýr
	 */
	public void setLastRow(int last_row) {
		lastRow = last_row;
	}

	/**
	 * Son sütuna atama yapar.
	 * 
	 * @param last_column
	 *            son sütun
	 */
	public void setLastColumn(int last_column) {
		lastColumn = last_column;
	}

	/**
	 * Yön atamasý yapar.
	 * 
	 * @param is_vertical
	 *            yön
	 */
	public void setVertical(boolean is_vertical) {
		isVertical = is_vertical;
	}

	/**
	 * Ýlk satýrý döndürür.
	 * 
	 * @return firstRow
	 */
	public int getFirstRow() {
		return firstRow;
	}

	/**
	 * Ýlk sütunu döndürür.
	 * 
	 * @return firstColumn
	 */
	public int getFirstColumn() {
		return firstColumn;
	}

	/**
	 * Son satýrý döndürür.
	 * 
	 * @return lastRow
	 */
	public int getLastRow() {
		return lastRow;
	}

	/**
	 * Son sütunu döndürür.
	 * 
	 * @return lastColumn
	 */
	public int getLastColumn() {
		return lastColumn;
	}

	/**
	 * Yönü döndürür.
	 * 
	 * @return isVertical
	 */
	public boolean isVertical() {
		return isVertical;
	}

	/**
	 * Bu fonksiyon iki locationý karþýlaþtýrýp eþit olup olmadýklarýný
	 * belirler.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		/** object Location a cast edilir. */
		Location location = (Location) object;
		/** Fieldlar karþýlaþtýrýlýr. */
		if (this.firstRow == location.firstRow) {
			if (this.firstColumn == location.firstColumn) {
				if (this.lastRow == location.lastRow) {
					if (this.lastColumn == location.lastColumn) {
						if (this.isVertical == location.isVertical) {
							/** Tümü eþitse true döndürülür. */
							return true;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
