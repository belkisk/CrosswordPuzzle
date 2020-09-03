package my.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;

/**
 * Bu sınıf sözlükle ilgili işlemleri içerir.
 * 
 * @author belkıs
 * 
 */
public class Dictionary {
	/**
	 * Bu fonksiyon sözlüğü satır satır okuyarak bir ArrayList oluşturur.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<ArrayList<Entry>> readDictionary(Context context) {
		/** İki boyutlu ArrayList tanımlanır. */
		ArrayList<ArrayList<Entry>> dictionary;
		String word = null;
		try {
			/** sozluk.txt dosyası açılır. */
			InputStream instream = context.getAssets().open("sozluk.txt");
			InputStreamReader inputreader = new InputStreamReader(instream);
			BufferedReader br;
			br = new BufferedReader(inputreader);
			String line;

			/** ArrayList oluşturulur. */
			dictionary = new ArrayList<ArrayList<Entry>>();
			/** Satır sonuna kadar dosya okunup buffer a yazılır. */
			while ((line = br.readLine()) != null) {
				/** Okunan string ':' karakterine göre ayrılır. */
				String[] stringArray = line.split(":");
				/**
				 * İlk stringdeki kelime grubu tek bir kelime olacak şekilde
				 * birleştirilir.
				 */
				String[] wordGroup = stringArray[0].trim().split(" ");
				/** '-' karakterine göre kelime ayrılır. */
				String[] wordBuilder = wordGroup[0].split("-");
				/**
				 * StringBuilder oluşturulup buna eklenerek parçalar
				 * birleştirilir.
				 */
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(wordBuilder[0]);
				if (wordBuilder.length > 1) {
					stringBuilder.append(wordBuilder[1]);
				}
				if (wordGroup.length > 1) {
					stringBuilder.append(wordGroup[1]);
				}
				/** Kelime oluşturuldu. */
				word = stringBuilder.toString();
				/** Kelime ve tanımıyla yeni bir Entry nesnesi oluşturulur. */
				Entry entry = new Entry(word, stringArray[1]);
				/**
				 * Kelimenin harf sayısına göre dictionary ye yerleştirilir.
				 */
				if (dictionary.size() <= word.length()) {
					for (int i = dictionary.size(); i <= word.length(); i++) {
						dictionary.add(new ArrayList<Entry>());
					}
				}
				dictionary.get(word.length()).add(entry);
			}
			/** Dosya kapatılır. */
			instream.close();
			/** dictionary döndürülür. */
			return dictionary;
			/** Exception durumlarında null döndürülür. */
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
