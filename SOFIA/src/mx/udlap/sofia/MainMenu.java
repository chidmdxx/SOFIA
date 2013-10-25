package mx.udlap.sofia;

import com.example.sofia.*;
import com.example.sofia.Theory_description;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		final ImageButton conjuntos_teoria = (ImageButton) findViewById(R.id.imageButton1);
		final ImageButton conjuntos_ejercicios = (ImageButton) findViewById(R.id.imageButton2);
		final ImageButton conjuntos_solver = (ImageButton) findViewById(R.id.imageButton3);
		final ImageButton conjuntos_resueltos = (ImageButton) findViewById(R.id.imageButton4);

		conjuntos_teoria.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(MainMenu.this,
						com.example.sofia.Theory_description.class);
				startActivity(sendTo);
				// finish();
			}
		});

		conjuntos_ejercicios.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(MainMenu.this,
						com.example.sofia.Solve_exercises.class);
				startActivity(sendTo);
				// finish();
			}
		});
		
		conjuntos_solver.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(MainMenu.this,
						com.example.sofia.Solve_solver.class);
				startActivity(sendTo);
				// finish();
			}
		});
		
		conjuntos_resueltos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(MainMenu.this,
						com.example.sofia.Seeanswer_exercises.class);
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

}// hola!1!!
// hola!2¡
