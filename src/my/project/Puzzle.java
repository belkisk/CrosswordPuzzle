package my.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import android.util.Log;

/**
 * Bu s�n�f bulmaca olu�turma i�lemlerini i�erir.
 * 
 * @author belk�s
 * 
 */
public class Puzzle {
	/** Yerle�tirilen kelimeler */
	private Stack<Entry> placed;
	/** Yerle�tirilen yerler */
	private Stack<Location> located;
	/** Bulmaca matrisi */
	private char[][] matrix;
	/** Denenmi� kelimeler */
	private List<Entry> tried;

	int size;

	/**
	 * Constructor.
	 * 
	 * @param size
	 */
	public Puzzle(int size) {
		this.size = size;
		matrix = new char[size][size];
		placed = new Stack<Entry>();
		located = new Stack<Location>();
		tried = new LinkedList<Entry>();
	}

	/**
	 * Bulmaca matrisini d�nd�r�r.
	 * 
	 * @return matrix
	 */
	public char[][] getPuzzle() {
		return matrix;
	}

	public boolean createPuzzle(Location location) {
		int size = matrix[0].length;
		int row = location.getFirstRow();
		int column = location.getFirstColumn();
		int k, start = 0;
		Entry entry = null;
		StringBuilder beginning = new StringBuilder();
		if (location.isVertical()) {
			for (k = row; k >= 0; k--) {
				if (matrix[k][column] == '#') {
					start = k + 1;
					break;
				}
				start = k;
			}
			for (k = start; k <= row; k++) {
				beginning.append(matrix[k][column]);
			}
			String begin = beginning.toString();
			int max = size - start;
			Location entry_location = null;
			do {
				entry = findBestString(begin, max);
				if (entry == null) {
					break;
				} else if (!topToBottomControl(entry.getWord(), row, column,
						start)) {
					entry_location = new Location(row, column, start
							+ entry.getWord().length() - 1, column, true);
					entry.getList().add(entry_location);
				}

				tried.add(entry);
				if (tried.equals(Bulmaca.getDictionary().get(max))) {
					max--;
				}
			} while ((entry.getList().contains(entry_location))
					|| (placed.indexOf(entry) != -1));
			if (entry == null) {
				matrix[row][column] = '#';
			} else {
				String word = entry.getWord();
				for (k = row; k < row + word.length() - begin.length() + 1; k++) {
					if ((begin.length() + k - row - 1) < 0)
						continue;
					matrix[k][column] = word.charAt(begin.length() + k - row
							- 1);
				}
				entry.setLocation(new Location(start, column, start
						+ word.length() - 1, column, true));
				placed.push(entry);
				Log.d("?????????????", entry.getWord());
			}
			tried.clear();
			Location new_location;
			if (k < size) {
				matrix[k][column] = '#';
				located.add(new Location(row, column, k - 1, column, true));
				if ((size - (k + 1)) > 1) {
					new_location = new Location(k + 1, column, size - 1,
							column, true);
				} else {
					new_location = new Location(column + 1, column + 1,
							column + 1, size - 1, false);
				}
			} else {
				if ((row == size - 1) && (column == size - 1)) {
					return true;
				} else {
					new_location = new Location(column + 1, column + 1,
							column + 1, size - 1, false);
				}
			}
			createPuzzle(new_location);
		} else {
			for (k = column; k >= 0; k--) {
				if (matrix[row][k] == '#') {
					start = k + 1;
					break;
				}
				start = k;
			}
			for (k = start; k < column; k++) {
				beginning.append(matrix[row][k]);
			}
			String begin = beginning.toString();
			int max = size - start;
			Location entry_location = null;

			do {
				if ((row == 0) && (column == 0)) {
					entry = stringFactory(Bulmaca.getDictionary().get(size));
				} else {
					entry = findBestString(begin, max);
				}
				if (entry == null) {
					break;
				} else if (!leftToRightControl(entry.getWord(), row, column,
						start)) {
					entry_location = new Location(row, column, row, start
							+ entry.getWord().length() - 1, false);
					entry.getList().add(entry_location);
				}

				tried.add(entry);
				if (tried.equals(Bulmaca.getDictionary().get(max))) {
					max--;
				}
			} while ((entry.getList().contains(entry_location))
					|| (placed.indexOf(entry) != -1));
			if (entry == null) {
				matrix[row][column] = '#';
			} else {
				String word = entry.getWord();
				for (k = column; k < column + word.length() - begin.length(); k++) {
					matrix[row][k] = word.charAt(k - column + begin.length());
				}
				entry.setLocation(new Location(row, start, row, start
						+ word.length() - 1, false));
				placed.push(entry);
				Log.d("?????????????", entry.getWord());
			}
			tried.clear();
			Location new_location;
			if (k < size) {

				matrix[row][k] = '#';
				located.add(new Location(row, column, row, k - 1, false));
				if (size - (k + 1) > 1) {
					new_location = new Location(row, k + 1, row, size - 1,
							false);
				} else {
					new_location = new Location(row, row, size - 1, row, true);
				}
			} else {
				new_location = new Location(row, row, size - 1, row, true);
			}
			createPuzzle(new_location);
		}
		return true;
	}

	/**
	 * Bu fonksiyon ald��� listten rastgele bir entry d�nd�r�r.
	 * 
	 * @param list
	 * @return entry
	 */
	private Entry stringFactory(ArrayList<Entry> list) {
		/** Rastgele say� olu�turulur . */
		Random rand = new Random(System.currentTimeMillis());
		int random = rand.nextInt(list.size());
		/** random indisli entry al�n�r. */
		Entry entry = list.get(random);
		/** entry d�nd�r�l�r. */
		return entry;
	}

	/**
	 * Bu fonksiyon verilen kelime ile ba�layan en fazla istenen karakterde
	 * rastgele Entry d�nd�r�r.
	 * 
	 * @param begin
	 * @param max
	 * @return entry
	 */
	private Entry findBestString(String begin, int max) {
		/** En fazla kelime boyutu 2 olmal�. */
		while (max >= begin.length()) {
			ArrayList<Entry> list = Bulmaca.getDictionary().get(max);
			int size = list.size();
			Entry entry = binarySearch(list, 0, size, begin);
			if (entry != null) {
				return entry;
			}
			/**
			 * beginle ba�layan kelime bulunamad�ysa max azalt�l�p daha
			 * k���k boyutlu kelime aranmaya devam edilir.
			 */
			max--;
		}
		/** Hi� uygun kelime bulunamad�ysa null d�nd�r�l�r. */
		return null;
	}

	/**
	 * Bu fonksiyon soldan sa�a yerle�tirilecek bir kelime i�in gerekli
	 * kontrolleri yapar.
	 */
	private boolean leftToRightControl(String word, int row, int column,
			int startIndex) {
		/** Saya�lar */
		int i, j, k = column;
		/**
		 * Kelimenin yerle�tirilmeye ba�lanaca�� indeksten kelime sonuna
		 * kadar her harf i�in kontrol yap�l�r.
		 */
		for (i = startIndex; i < startIndex + word.length(); i++) {
			StringBuilder sb = new StringBuilder();
			/**
			 * Karakterden �nceki karakterler '#' ye kadar, '#' yoksa en
			 * ba�a kadar sb ye eklenir.
			 */
			for (j = row - 1; j >= 0 && matrix[i][j] != '#'; j--) {
				sb.append(matrix[j][i]);
			}
			StringBuffer buffer = new StringBuffer(sb.toString());
			StringBuilder reverse = new StringBuilder();
			/**
			 * Al�nan karakterlerin s�ras� ters �evrilip yukar�dan
			 * a�a�� do�ru bir kelime olu�turulmas� sa�lan�r.
			 */
			reverse.append(buffer.reverse().toString());
			/** Yerle�tirilecek kelimenin harfi de eklenir. */
			reverse.append(word.charAt(k - column));
			/**
			 * Bu kelime ile ba�layan bir kelime olup olmad��� kontrol
			 * edilir; e�er �yle bir kelime yoksa false d�nd�r�l�r.
			 */
			String begin = reverse.toString();
			if (findBestString(begin, size - j - 1) == null) {
				return false;
			}
			k++;
		}
		/**
		 * E�er hi�bir s�tunda sorun ��km�yorsa yani kelimenin her
		 * harfi location i�in uygunsa true d�nd�r�r.
		 */
		return true;
	}

	/**
	 * Bu fonksiyon yukar�dan a�a��ya yerle�tirilecek bir kelime
	 * i�in gerekli kontrolleri yapar.
	 */
	private boolean topToBottomControl(String word, int row, int column,
			int startIndex) {
		/** Saya�lar */
		int i, j, k = row;
		/**
		 * Kelimenin yerle�tirilmeye ba�lanaca�� indeksten kelime sonuna
		 * kadar her harf i�in kontrol yap�l�r.
		 */
		for (i = startIndex; i < startIndex + word.length(); i++) {
			StringBuilder sb = new StringBuilder();
			/**
			 * Karakterden �nceki karakterler '#' ye kadar, '#' yoksa en
			 * ba�a kadar sb ye eklenir.
			 */
			for (j = column - 1; j >= 0 && matrix[i][j] != '#'; j--) {
				sb.append(matrix[i][j]);
			}
			StringBuffer buffer = new StringBuffer(sb.toString());
			StringBuilder reverse = new StringBuilder();
			/**
			 * Al�nan karakterlerin s�ras� ters �evrilip soldan sa�a
			 * do�ru bir kelime olu�turulmas� sa�lan�r.
			 */
			reverse.append(buffer.reverse().toString());
			/** Yerle�tirilecek kelimenin harfi de eklenir. */
			reverse.append(word.charAt(k - row));

			String string = reverse.toString();
			/**
			 * Bu kelime ile ba�layan bir kelime olup olmad��� kontrol
			 * edilir; e�er �yle bir kelime yoksa false d�nd�r�l�r.
			 */
			if (findBestString(string, size - j - 1) == null) {
				return false;
			}
			k++;
		}
		/**
		 * E�er hi�bir sat�rda sorun ��km�yorsa yani kelimenin her
		 * harfi location i�in uygunsa true d�nd�r�r.
		 */
		return true;
	}

	private Entry binarySearch(ArrayList<Entry> list, int start, int end,
			String key) {
		// try {
		if ((end - start) == 0) {
			return null;
		} else {
			Entry pivot = list.get((start + end) / 2);
			// Log.d("***********************", start + "    " + end);
			int k = 0;
			try {
				while (placed.contains(pivot) || tried.contains(pivot)) {
					pivot = list.get(((start + end) / 2) + 1 + k);
					k++;
				}
			} catch (IndexOutOfBoundsException ex) {
				return null;
			}
			if (pivot.getWord().startsWith(key)) {
				return pivot;
			} else {
				if ((end - start) == 1) {
					pivot = list.get(start);
					if (pivot.getWord().startsWith(key)) {
						return pivot;
					} else {
						return null;
					}
				}
				int i = key.compareTo(pivot.getWord());
				if (i < 0) {
					return binarySearch(list, start, (start + end) / 2, key);
				} else if (i > 0) {
					return binarySearch(list, start + ((end - start) / 2), end,
							key);
				}
			}
		}
		// } catch (StackOverflowError ex) {
		// return null;
		// }
		return null;
	}

	public Stack<Entry> getPlacedEntries() {
		return placed;
	}

	private ArrayList<ArrayList<Entry>> getQuestions() {
		ArrayList<ArrayList<Entry>> questions = new ArrayList<ArrayList<Entry>>();
		questions.add(new ArrayList<Entry>());
		questions.add(new ArrayList<Entry>());
		while (!placed.empty()) {
			Entry entry = placed.pop();
			if (!(entry.getLocation().isVertical())) {
				questions.get(0).add(entry);
			} else {
				questions.get(1).add(entry);
			}
		}

		sortByRow(questions.get(0));
		sortByColumn(questions.get(1));

		return questions;
	}

	public String getVerticalQuestions() {
		ArrayList<ArrayList<Entry>> questions = getQuestions();
		ArrayList<Entry> v_questions = questions.get(1);
		int m = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {

			sb.append(i + 1);
			while ((m < v_questions.size())
					&& (v_questions.get(m).getLocation().getFirstColumn() == i)) {
				sb.append("-");
				String description = v_questions.get(m).getDescription();
				sb.append(description);
				m++;
			}
			sb.append("  ");
		}
		return sb.toString();
	}

	public String getHorizontalQuestions() {
		ArrayList<ArrayList<Entry>> questions = getQuestions();
		ArrayList<Entry> h_questions = questions.get(0);
		int m = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {

			sb.append(i + 1);
			while ((m < h_questions.size())
					&& (h_questions.get(m).getLocation().getFirstRow() == i)) {
				sb.append("-");
				String description = h_questions.get(m).getDescription();
				sb.append(description);
				m++;
			}
			sb.append("  ");
		}
		return sb.toString();
	}

	private void sortByColumn(ArrayList<Entry> list) {
		int i, j;
		int n = list.size();
		for (i = 0; i < n; i++) {
			int pos = i;
			for (j = i + 1; j < n; j++) {
				if (list.get(j).getLocation().getFirstColumn() < list.get(pos)
						.getLocation().getFirstColumn()) {
					pos = j;
				}
			}
			Entry temp = list.get(i);
			list.set(i, list.get(pos));
			list.set(pos, temp);
		}
	}

	private void sortByRow(ArrayList<Entry> list) {
		int i, j;
		int n = list.size();
		for (i = 0; i < n; i++) {
			int pos = i;
			for (j = i + 1; j < n; j++) {
				if (list.get(j).getLocation().getFirstRow() < list.get(pos)
						.getLocation().getFirstRow()) {
					pos = j;
				}
			}
			Entry temp = list.get(i);
			list.set(i, list.get(pos));
			list.set(pos, temp);
		}
	}
}