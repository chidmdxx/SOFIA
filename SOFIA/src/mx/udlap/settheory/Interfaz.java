package mx.udlap.settheory;

import mx.udlap.sofia.MainMenu;
import mx.udlap.sofia.R;
import mx.udlap.sofia.SQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Interfaz extends Activity {
	
	public static boolean teoriaVista;
	public Button but = null;
	public Button but1 = null;
	public Button but2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interfaz);
		but = (Button) findViewById(R.id.theory);
		but1 = (Button) findViewById(R.id.Exercises);
		but2 = (Button) findViewById(R.id.Solver);
		
		VerificaTeoria();
		if(teoriaVista == false){
			but1.setEnabled(false);
			but2.setEnabled(false);
		}

		but.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(Interfaz.this, Theory_description.class);
				startActivity(sendTo);
				
			}
		});
		
		but1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(Interfaz.this, Theory_exercises.class);
				startActivity(sendTo);
				
			}
		});
		
		but2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(Interfaz.this, Solve_exercises.class);
				startActivity(sendTo);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.interfaz, menu);
		return true;
	}
	
	public void VerificaTeoria(){
		String temp = "no";
		SQLiteHelper usdbh = new SQLiteHelper(Interfaz.this,
				"Base de datos", null, 2);
		SQLiteDatabase db = usdbh.getReadableDatabase();
		Cursor c = db.rawQuery("SELECT teoria_vista FROM teoria WHERE id_modulo = \'conjuntos\'", null);
		if(c.moveToFirst() != false){
			temp = c.getString(0);
		}
		db.close();
		
		if(temp.equals("si")){
			teoriaVista = true;
		}else{
			teoriaVista = false;
		}
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		if(teoriaVista == false){
			VerificaTeoria();
		}
		if(teoriaVista == true){
			but1.setEnabled(true);
			but2.setEnabled(true);
		}
		
	}

}
