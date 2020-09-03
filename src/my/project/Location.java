package my.project;

/**
 * Bu s�n�f yerle�tirilen bir kelimenin yer ve y�n bilgilerini i�erir.
 * 
 * @author belk�s
 * 
 */
public class Location {

	/** location�n ba�lang�� konumunun sat�r indeksi. */
	private int firstRow;

	/** location�n ba�lang�� konumunun s�tun indeksi. */
	private int firstColumn;

	/** location�n biti� konumunun sat�r indeksi. */
	private int lastRow;

	/** location�n biti� indeksinin s�tun indeksi. */
	private int lastColumn;

	/** location�n y�n�n� belirler; dikeyse true, yataysa false. */
	private boolean isVertical;

	/**
	 * Ald��� parametreleri fieldlara atayarak yeni bir location olu�turur.
	 * Constructor.
	 * 
	 * @param first_row
	 *            ilk sat�r
	 * @param first_column
	 *            ilk s�tun
	 * @param last_row
	 *            son sat�r
	 * @param last_column
	 *            son s�tun
	 * @param is_vertical
	 *            y�n
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
	 * �lk sat�ra atama yapar.
	 * 
	 * @param first_row
	 *            ilk sat�r
	 */
	public void setFirstRow(int first_row) {
		firstRow = first_row;
	}

	/**
	 * �lk s�tuna atama yapar.
	 * 
	 * @param first_column
	 *            ilk s�tun
	 */
	public void setFirstColumn(int first_column) {
		firstColumn = first_column;
	}

	/**
	 * Son sat�ra atama yapar.
	 * 
	 * @param last_row
	 *            son sat�r
	 */
	public void setLastRow(int last_row) {
		lastRow = last_row;
	}

	/**
	 * Son s�tuna atama yapar.
	 * 
	 * @param last_column
	 *            son s�tun
	 */
	public void setLastColumn(int last_column) {
		lastColumn = last_column;
	}

	/**
	 * Y�n atamas� yapar.
	 * 
	 * @param is_vertical
	 *            y�n
	 */
	public void setVertical(boolean is_vertical) {
		isVertical = is_vertical;
	}

	/**
	 * �lk sat�r� d�nd�r�r.
	 * 
	 * @return firstRow
	 */
	public int getFirstRow() {
		return firstRow;
	}

	/**
	 * �lk s�tunu d�nd�r�r.
	 * 
	 * @return firstColumn
	 */
	public int getFirstColumn() {
		return firstColumn;
	}

	/**
	 * Son sat�r� d�nd�r�r.
	 * 
	 * @return lastRow
	 */
	public int getLastRow() {
		return lastRow;
	}

	/**
	 * Son s�tunu d�nd�r�r.
	 * 
	 * @return lastColumn
	 */
	public int getLastColumn() {
		return lastColumn;
	}

	/**
	 * Y�n� d�nd�r�r.
	 * 
	 * @return isVertical
	 */
	public boolean isVertical() {
		return isVertical;
	}

	/**
	 * Bu fonksiyon iki location� kar��la�t�r�p e�it olup olmad�klar�n�
	 * belirler.
	 * 
	 */
	@Override
	public boolean equals(Object object) {
		/** object Location a cast edilir. */
		Location location = (Location) object;
		/** Fieldlar kar��la�t�r�l�r. */
		if (this.firstRow == location.firstRow) {
			if (this.firstColumn == location.firstColumn) {
				if (this.lastRow == location.lastRow) {
					if (this.lastColumn == location.lastColumn) {
						if (this.isVertical == location.isVertical) {
							/** T�m� e�itse true d�nd�r�l�r. */
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
