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
		String resultado = extras.getString("resultado");

		 EditText textconjuntoa = (EditText) findViewById(R.id.conjuntoA);
		 
		 textconjuntoa.setText(resultado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solve_solver, menu);
		return true;
	}

}
