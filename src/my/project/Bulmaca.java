package my.project;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Bu s�n�f bulmacan�n soruldu�u Activity s�n�f�d�r.
 * 
 * @author belk�s
 * 
 */
public class Bulmaca extends Activity {

	/** Bulmaca boyutu */
	public static int puzzleSize;
	/** Bulmaca entry lerinden oluşan ArrayList */
	private static ArrayList<ArrayList<Entry>> crosswordPuzzle;

	char[][] matrix;

	/**
	 * Activity ilk olu�turuldu�unda �a��r�l�r.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bulmaca2);

		crosswordPuzzle = Dictionary.readDictionary(this);
		Puzzle bulmaca = new Puzzle(puzzleSize);
		Location location = new Location(0, 0, 0, puzzleSize - 1, false);
		int i, j, k = 0;
		if (bulmaca.createPuzzle(location)) {
			matrix = bulmaca.getPuzzle();
			for (i = 0; i < puzzleSize; i++) {
				StringBuilder builder = new StringBuilder();
				for (j = 0; j < puzzleSize; j++) {
					builder.append(matrix[i][j]);
				}
				Log.d("!!!!!!!!!!!!!!!!!!!!!", builder.toString());
			}
		}

		final EditText[][] edits = new EditText[10][10];
		edits[0][0] = (EditText) findViewById(R.id.EditText00);
		edits[0][1] = (EditText) findViewById(R.id.EditText01);
		edits[0][2] = (EditText) findViewById(R.id.EditText02);
		edits[0][3] = (EditText) findViewById(R.id.EditText03);
		edits[0][4] = (EditText) findViewById(R.id.EditText04);
		edits[0][5] = (EditText) findViewById(R.id.EditText05);
		edits[0][6] = (EditText) findViewById(R.id.EditText06);
		edits[0][7] = (EditText) findViewById(R.id.EditText07);
		edits[0][8] = (EditText) findViewById(R.id.EditText08);
		edits[0][9] = (EditText) findViewById(R.id.EditText09);
		edits[1][0] = (EditText) findViewById(R.id.EditText10);
		edits[1][1] = (EditText) findViewById(R.id.EditText11);
		edits[1][2] = (EditText) findViewById(R.id.EditText12);
		edits[1][3] = (EditText) findViewById(R.id.EditText13);
		edits[1][4] = (EditText) findViewById(R.id.EditText14);
		edits[1][5] = (EditText) findViewById(R.id.EditText15);
		edits[1][6] = (EditText) findViewById(R.id.EditText16);
		edits[1][7] = (EditText) findViewById(R.id.EditText17);
		edits[1][8] = (EditText) findViewById(R.id.EditText18);
		edits[1][9] = (EditText) findViewById(R.id.EditText19);
		edits[2][0] = (EditText) findViewById(R.id.EditText20);
		edits[2][1] = (EditText) findViewById(R.id.EditText21);
		edits[2][2] = (EditText) findViewById(R.id.EditText22);
		edits[2][3] = (EditText) findViewById(R.id.EditText23);
		edits[2][4] = (EditText) findViewById(R.id.EditText24);
		edits[2][5] = (EditText) findViewById(R.id.EditText25);
		edits[2][6] = (EditText) findViewById(R.id.EditText26);
		edits[2][7] = (EditText) findViewById(R.id.EditText27);
		edits[2][8] = (EditText) findViewById(R.id.EditText28);
		edits[2][9] = (EditText) findViewById(R.id.EditText29);
		edits[3][0] = (EditText) findViewById(R.id.EditText30);
		edits[3][1] = (EditText) findViewById(R.id.EditText31);
		edits[3][2] = (EditText) findViewById(R.id.EditText32);
		edits[3][3] = (EditText) findViewById(R.id.EditText33);
		edits[3][4] = (EditText) findViewById(R.id.EditText34);
		edits[3][5] = (EditText) findViewById(R.id.EditText35);
		edits[3][6] = (EditText) findViewById(R.id.EditText36);
		edits[3][7] = (EditText) findViewById(R.id.EditText37);
		edits[3][8] = (EditText) findViewById(R.id.EditText38);
		edits[3][9] = (EditText) findViewById(R.id.EditText39);
		edits[4][0] = (EditText) findViewById(R.id.EditText40);
		edits[4][1] = (EditText) findViewById(R.id.EditText41);
		edits[4][2] = (EditText) findViewById(R.id.EditText42);
		edits[4][3] = (EditText) findViewById(R.id.EditText43);
		edits[4][4] = (EditText) findViewById(R.id.EditText44);
		edits[4][5] = (EditText) findViewById(R.id.EditText45);
		edits[4][6] = (EditText) findViewById(R.id.EditText46);
		edits[4][7] = (EditText) findViewById(R.id.EditText47);
		edits[4][8] = (EditText) findViewById(R.id.EditText48);
		edits[4][9] = (EditText) findViewById(R.id.EditText49);
		edits[5][0] = (EditText) findViewById(R.id.EditText50);
		edits[5][1] = (EditText) findViewById(R.id.EditText51);
		edits[5][2] = (EditText) findViewById(R.id.EditText52);
		edits[5][3] = (EditText) findViewById(R.id.EditText53);
		edits[5][4] = (EditText) findViewById(R.id.EditText54);
		edits[5][5] = (EditText) findViewById(R.id.EditText55);
		edits[5][6] = (EditText) findViewById(R.id.EditText56);
		edits[5][7] = (EditText) findViewById(R.id.EditText57);
		edits[5][8] = (EditText) findViewById(R.id.EditText58);
		edits[5][9] = (EditText) findViewById(R.id.EditText59);
		edits[6][0] = (EditText) findViewById(R.id.EditText60);
		edits[6][1] = (EditText) findViewById(R.id.EditText61);
		edits[6][2] = (EditText) findViewById(R.id.EditText62);
		edits[6][3] = (EditText) findViewById(R.id.EditText63);
		edits[6][4] = (EditText) findViewById(R.id.EditText64);
		edits[6][5] = (EditText) findViewById(R.id.EditText65);
		edits[6][6] = (EditText) findViewById(R.id.EditText66);
		edits[6][7] = (EditText) findViewById(R.id.EditText67);
		edits[6][8] = (EditText) findViewById(R.id.EditText68);
		edits[6][9] = (EditText) findViewById(R.id.EditText69);
		edits[7][0] = (EditText) findViewById(R.id.EditText70);
		edits[7][1] = (EditText) findViewById(R.id.EditText71);
		edits[7][2] = (EditText) findViewById(R.id.EditText72);
		edits[7][3] = (EditText) findViewById(R.id.EditText73);
		edits[7][4] = (EditText) findViewById(R.id.EditText74);
		edits[7][5] = (EditText) findViewById(R.id.EditText75);
		edits[7][6] = (EditText) findViewById(R.id.EditText76);
		edits[7][7] = (EditText) findViewById(R.id.EditText77);
		edits[7][8] = (EditText) findViewById(R.id.EditText78);
		edits[7][9] = (EditText) findViewById(R.id.EditText79);
		edits[8][0] = (EditText) findViewById(R.id.EditText80);
		edits[8][1] = (EditText) findViewById(R.id.EditText81);
		edits[8][2] = (EditText) findViewById(R.id.EditText82);
		edits[8][3] = (EditText) findViewById(R.id.EditText83);
		edits[8][4] = (EditText) findViewById(R.id.EditText84);
		edits[8][5] = (EditText) findViewById(R.id.EditText85);
		edits[8][6] = (EditText) findViewById(R.id.EditText86);
		edits[8][7] = (EditText) findViewById(R.id.EditText87);
		edits[8][8] = (EditText) findViewById(R.id.EditText88);
		edits[8][9] = (EditText) findViewById(R.id.EditText89);
		edits[9][0] = (EditText) findViewById(R.id.EditText90);
		edits[9][1] = (EditText) findViewById(R.id.EditText91);
		edits[9][2] = (EditText) findViewById(R.id.EditText92);
		edits[9][3] = (EditText) findViewById(R.id.EditText93);
		edits[9][4] = (EditText) findViewById(R.id.EditText94);
		edits[9][5] = (EditText) findViewById(R.id.EditText95);
		edits[9][6] = (EditText) findViewById(R.id.EditText96);
		edits[9][7] = (EditText) findViewById(R.id.EditText97);
		edits[9][8] = (EditText) findViewById(R.id.EditText98);
		edits[9][9] = (EditText) findViewById(R.id.EditText99);

		for (i = 0; i < 10; i++) {
			for (k = 0; k < 10; k++) {
				edits[i][k].setVisibility(View.INVISIBLE);
			}
		}

		for (i = 0; i < puzzleSize; i++) {
			for (k = 0; k < puzzleSize; k++) {
				edits[i][k].setVisibility(View.VISIBLE);
			}
		}

		TextView[] numbers = new TextView[20];
		numbers[0] = (TextView) findViewById(R.id.TextView00);
		numbers[1] = (TextView) findViewById(R.id.TextView01);
		numbers[2] = (TextView) findViewById(R.id.TextView02);
		numbers[3] = (TextView) findViewById(R.id.TextView03);
		numbers[4] = (TextView) findViewById(R.id.TextView04);
		numbers[5] = (TextView) findViewById(R.id.TextView05);
		numbers[6] = (TextView) findViewById(R.id.TextView06);
		numbers[7] = (TextView) findViewById(R.id.TextView07);
		numbers[8] = (TextView) findViewById(R.id.TextView08);
		numbers[9] = (TextView) findViewById(R.id.TextView09);
		numbers[10] = (TextView) findViewById(R.id.TextView10);
		numbers[11] = (TextView) findViewById(R.id.TextView11);
		numbers[12] = (TextView) findViewById(R.id.TextView12);
		numbers[13] = (TextView) findViewById(R.id.TextView13);
		numbers[14] = (TextView) findViewById(R.id.TextView14);
		numbers[15] = (TextView) findViewById(R.id.TextView15);
		numbers[16] = (TextView) findViewById(R.id.TextView16);
		numbers[17] = (TextView) findViewById(R.id.TextView17);
		numbers[18] = (TextView) findViewById(R.id.TextView18);
		numbers[19] = (TextView) findViewById(R.id.TextView19);

		for (i = puzzleSize; i < 10; i++) {
			numbers[i].setVisibility(View.INVISIBLE);
		}

		for (i = 10 + puzzleSize; i < 20; i++) {
			numbers[i].setVisibility(View.INVISIBLE);
		}

		for (i = 0; i < puzzleSize; i++) {
			for (k = 0; k < puzzleSize; k++) {
				if (matrix[i][k] == '#') {
					edits[i][k].setBackgroundColor(Color.BLACK);
					edits[i][k].setEnabled(false);
				}
			}
		}

		TextView horizontal = (TextView) findViewById(R.id.horizontalQuestions);
		TextView vertical = (TextView) findViewById(R.id.verticalQuestions);

		horizontal.setText(bulmaca.getHorizontalQuestions());
		vertical.setText(bulmaca.getVerticalQuestions());

		Button finish = (Button) findViewById(R.id.bitir);
		finish.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				for (int m = 0; m < puzzleSize; m++) {
					for (int n = 0; n < puzzleSize; n++) {
						if ((!edits[m][n].getText().toString().matches(""))
								&& (edits[m][n].getText().charAt(0) == matrix[m][n])) {
							edits[m][n].setBackgroundColor(Color.GREEN);
						} else {
							edits[m][n].setBackgroundColor(Color.RED);
						}
					}
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

	/**
	 * crosswordPuzzle � d�nd�r�r.
	 * 
	 * @return crosswordPuzzle
	 */
	public static ArrayList<ArrayList<Entry>> getDictionary() {
		return crosswordPuzzle;
	}
}
