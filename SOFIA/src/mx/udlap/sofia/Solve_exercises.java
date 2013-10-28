/*package com.example.sofia;


import java.util.StringTokenizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import mx.udlap.settheory.*;

public class Solve_exercises extends Activity {

	List<String> A,B,U,Resultado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solve_exercises);
		// creamos el boton que queremos que realice nuestra accion
		final Button but = (Button) findViewById(R.id.union);
		final Button but1 = (Button) findViewById(R.id.interseccion);
		final Button but2 = (Button) findViewById(R.id.diferencia);
		final Button but3 = (Button) findViewById(R.id.a_complemento);
		final Button but4 = (Button) findViewById(R.id.b_complemento);
		// Usamos un StringTokenizer para separar cada elemento de la cadena que el usuario ha dado
		
		
		
but.setOnClickListener(new View.OnClickListener() {
			
			@Override
		// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
			public void onClick(View v) {
				Intent sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
				leerLosConjuntos();
				Resultado=SetTheoryOperations.Union(A, B);

				sendTo.putExtra("resultado", Resultado.toString());
				startActivity(sendTo);

				
			}
		});
but1.setOnClickListener(new View.OnClickListener() {
	
	@Override
// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
	public void onClick(View v) {
		Intent sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
		leerLosConjuntos();
		Resultado=SetTheoryOperations.Intersection(A, B);
		sendTo.putExtra("resultado", Resultado.toString());
		startActivity(sendTo);

		
	}
});
but2.setOnClickListener(new View.OnClickListener() {
	
	@Override
// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
	public void onClick(View v) {
		Intent sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
		leerLosConjuntos();
		Resultado=SetTheoryOperations.Diference(A, B);
		sendTo.putExtra("resultado", Resultado.toString());
		startActivity(sendTo);

		
	}
});
but3.setOnClickListener(new View.OnClickListener() {
	
	@Override
// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
	public void onClick(View v) {
		Intent sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
		leerLosConjuntos();
		Resultado=SetTheoryOperations.Complement(U, A);
		sendTo.putExtra("resultado", Resultado.toString());
		startActivity(sendTo);

		
	}
});
but4.setOnClickListener(new View.OnClickListener() {
	
	@Override
// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
	public void onClick(View v) {
		Intent sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
		leerLosConjuntos();
		Resultado=SetTheoryOperations.Complement(U, B);
		sendTo.putExtra("resultado", Resultado.toString());
		startActivity(sendTo);

		
	}
});
	}

	private void leerLosConjuntos()
	{
		EditText conjuntoa = (EditText) findViewById(R.id.conjuntoA);
		A=new ArrayList<String>();
		A=Arrays.asList(conjuntoa.getText().toString().split(" "));
		
		EditText conjuntob = (EditText) findViewById(R.id.conjuntoB);
		B=new ArrayList<String>();
		B=Arrays.asList(conjuntob.getText().toString().split(" "));

		EditText conjuntouniverso = (EditText) findViewById(R.id.universo);
		U=new ArrayList<String>();
		U=Arrays.asList(conjuntouniverso.getText().toString().split(" "));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solve_exercises, menu);
		return true;
	}

}
*/
