/*package com.example.sofia;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Interfaz extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interfaz);
		final Button but = (Button) findViewById(R.id.theory);
		final Button but1 = (Button) findViewById(R.id.Exercises);
		final Button but2 = (Button) findViewById(R.id.Solver);
		
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

}
*/
