package my.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Bu sýnýf Kare Bulmacada çalýþtýrýlan ilk Activity sýnýfýdýr. Kullanýcýdan
 * bulmaca boyutunu alýp, diðer Activity sýnýfýný çalýþtýrýr.
 * 
 * @author belkýs
 * 
 */
public class KareBulmacaActivity extends Activity {
	/** boyutun girileceði alan */
	public static TextView txtName;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/** "oluþtur" butonu */
		Button create = (Button) findViewById(R.id.create);
		create.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				txtName = (TextView) findViewById(R.id.txtName);
				/** txtName e yazýlan boyut alýnýyor. */
				String size = txtName.getText().toString();
				/** integer a parse ediliyor. */
				try {
					int puzzle_size = Integer.parseInt(size);
					/** size ýn [2,10] aralýðýnda olmasý kontrol ediliyor. */
					if ((puzzle_size >= 2) && (puzzle_size <= 10)) {
						Bulmaca.puzzleSize = puzzle_size;
						/** Diðer activity çalýþtýrýlýyor. */
						startActivity(new Intent("my.project.KAREBULMACA"));
					} else {
						DisplayToast("Boyutu kontrol ederek tekrar giriniz.");
					}
				} catch (NumberFormatException e) {
					Toast.makeText(getBaseContext(),
							"Lütfen bir boyut giriniz.", Toast.LENGTH_LONG)
							.show();
					return;
				}
			}
		});
	}

	/**
	 * Ekrana kýsa süreli bir mesaj yazdýrýr.
	 * 
	 * @param msg
	 * 
	 */
	public void DisplayToast(String msg) {
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
	}

}