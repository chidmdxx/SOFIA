package com.example.sofia;

import java.util.*;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class Solve_solver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solve_solver);
		// Obtenemos los datos de nuestra otra actividad y lo asginamos al EditText (Resultado)
		Bundle extras = getIntent().getExtras();
		String conjuntoa = extras.getString("conjuntoa");
		String conjuntob = extras.getString("conjuntob");
		String conjuntouniverso = extras.getString("conjuntouniverso");
		
		// Usamos un StringTokenizer para separar cada elemento de la cadena que el usuario ha dado
		 StringTokenizer tokens;
		 tokens = new StringTokenizer(conjuntoa,",");
		 StringTokenizer tokensb;
		 tokensb = new StringTokenizer(conjuntob,",");
		 StringTokenizer tokensu;
		 tokensu = new StringTokenizer(conjuntouniverso,",");
		 
		 EditText textconjuntoa = (EditText) findViewById(R.id.conjuntoA);
		 
		 
		 textconjuntoa.setText(conjuntoa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solve_solver, menu);
		return true;
	}

}