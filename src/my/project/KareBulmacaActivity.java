package my.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Bu s�n�f Kare Bulmacada �al��t�r�lan ilk Activity s�n�f�d�r. Kullan�c�dan
 * bulmaca boyutunu al�p, di�er Activity s�n�f�n� �al��t�r�r.
 * 
 * @author belk�s
 * 
 */
public class KareBulmacaActivity extends Activity {
	/** boyutun girilece�i alan */
	public static TextView txtName;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/** "olu�tur" butonu */
		Button create = (Button) findViewById(R.id.create);
		create.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				txtName = (TextView) findViewById(R.id.txtName);
				/** txtName e yaz�lan boyut al�n�yor. */
				String size = txtName.getText().toString();
				/** integer a parse ediliyor. */
				try {
					int puzzle_size = Integer.parseInt(size);
					/** size �n [2,10] aral���nda olmas� kontrol ediliyor. */
					if ((puzzle_size >= 2) && (puzzle_size <= 10)) {
						Bulmaca.puzzleSize = puzzle_size;
						/** Di�er activity �al��t�r�l�yor. */
						startActivity(new Intent("my.project.KAREBULMACA"));
					} else {
						DisplayToast("Boyutu kontrol ederek tekrar giriniz.");
					}
				} catch (NumberFormatException e) {
					Toast.makeText(getBaseContext(),
							"L�tfen bir boyut giriniz.", Toast.LENGTH_LONG)
							.show();
					return;
				}
			}
		});
	}

	/**
	 * Ekrana k�sa s�reli bir mesaj yazd�r�r.
	 * 
	 * @param msg
	 * 
	 */
	public void DisplayToast(String msg) {
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
	}

}