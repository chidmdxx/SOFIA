/*package com.example.sofia;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Theory_exercises extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theory_exercises);
		final Button but = (Button) findViewById(R.id.theory);
		
but.setOnClickListener(new View.OnClickListener() {
			
			@Override
		// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
			public void onClick(View v) {
				Intent sendTo = new Intent(Theory_exercises.this, Solve_exercises.class);
				startActivity(sendTo);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.theory_exercises, menu);
		return true;
	}

}
*/