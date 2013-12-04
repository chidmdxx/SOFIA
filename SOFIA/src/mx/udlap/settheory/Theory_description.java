package mx.udlap.settheory;

import mx.udlap.sofia.MainMenu;
import mx.udlap.sofia.R;
import mx.udlap.sofia.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class Theory_description extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theory_description);
		
		SQLiteHelper usdbh = new SQLiteHelper(Theory_description.this,
				"Base de datos", null, 2);
		SQLiteDatabase db = usdbh.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("teoria_vista", "si");
		db.update("teoria", values, "id_modulo = \'conjuntos\'", null);
		db.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.theory_description, menu);
		return true;
	}

}
