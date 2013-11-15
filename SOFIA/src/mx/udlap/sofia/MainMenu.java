package mx.udlap.sofia;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		
		/*Botton para entrar a triangulos*/
		final ImageButton triangulos = (ImageButton) findViewById(R.id.imageButton3);
		triangulos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				int num_clicks = 0;
				SQLiteHelper usdbh = new SQLiteHelper(MainMenu.this,
						"Base de datos", null, 2);
				SQLiteDatabase db = usdbh.getWritableDatabase();
				Cursor c = db.rawQuery("SELECT * FROM modulos WHERE id_modulo = \'triangulos\'", null);
				if(c.moveToFirst() != false){
					num_clicks = c.getInt(1);
				}
				
				ContentValues values = new ContentValues();
				values.put("numero_de_clicks", num_clicks+1);
				db.update("modulos", values, "id_modulo = \'triangulos\'", null);
				db.close();

				Intent sendTo = new Intent(MainMenu.this,
						com.example.sofiaTriangulo.Triangulo.class);
				startActivity(sendTo);
				// finish();
			}
		});
		/*----------------------------------*/

		final ImageButton conjuntos = (ImageButton) findViewById(R.id.imageButton2);

		conjuntos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				int num_clicks = 0;
				SQLiteHelper usdbh = new SQLiteHelper(MainMenu.this,
						"Base de datos", null, 2);
				SQLiteDatabase db = usdbh.getWritableDatabase();
				Cursor c = db.rawQuery("SELECT * FROM modulos WHERE id_modulo = \'conjuntos\'", null);
				if(c.moveToFirst() != false){
					num_clicks = c.getInt(1);
				}
				
				ContentValues values = new ContentValues();
				values.put("numero_de_clicks", num_clicks+1);
				db.update("modulos", values, "id_modulo = \'conjuntos\'", null);
				db.close();
				
				Intent sendTo = new Intent(MainMenu.this,
						com.example.sofia.Interfaz.class);
				startActivity(sendTo);
				// finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
