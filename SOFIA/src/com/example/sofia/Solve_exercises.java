package com.example.sofia;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Solve_exercises extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solve_exercises);
		// creamos el boton que queremos que realice nuestra accion
		final Button but = (Button) findViewById(R.id.union);
		
but.setOnClickListener(new View.OnClickListener() {
			
			@Override
		// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
			public void onClick(View v) {
				Intent sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
				EditText conjuntoa = (EditText) findViewById(R.id.conjuntoA);
				sendTo.putExtra("conjuntoa", conjuntoa.getText().toString());
				EditText conjuntob = (EditText) findViewById(R.id.conjuntoB);
				sendTo.putExtra("conjuntob", conjuntob.getText().toString());
				EditText conjuntouniverso = (EditText) findViewById(R.id.universo);
				sendTo.putExtra("conjuntouniverso", conjuntouniverso.getText().toString());
				startActivity(sendTo);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solve_exercises, menu);
		return true;
	}

}
