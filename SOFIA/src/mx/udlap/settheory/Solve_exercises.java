package mx.udlap.settheory;

import java.util.StringTokenizer;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import mx.udlap.sofia.R;

public class Solve_exercises extends Activity {

	List<String> A,B,U,Resultado;
	Spinner lista;
	String [] datos ={"--Operaciones--",
					  "Union    (U)",
					  "Interseccion   ()",
					  "Diferencia    (-)",
					  "Complemento de A    (A')",
					  "Complemento de B    (B')",
					  "(A ���   B)'",
	 				  "(A ���   B)'"};
	
	int  variable;
	
	boolean conjuntosCorrectos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solve_exercises);
		
		lista  = (Spinner)findViewById(R.id.lista1);
		Button boton = (Button) findViewById(R.id.resolver);

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
		lista.setAdapter(adaptador);

		lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				EditText Resul;
				
				switch (arg2)
				{
					case 1:
						
						variable = 1;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Union(A, B);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						 Resul.setText(Resultado.toString());
						break;
					
					case 2:
						
						variable = 2;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Intersection(A, B);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						Resul.setText(Resultado.toString());
						break;
					
					case 3:
						
						variable = 3;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Diference(A, B);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						Resul.setText(Resultado.toString());
						break;
					
					case 4:
						
						variable = 4;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Complement(U, A);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						Resul.setText(Resultado.toString());
						break;
						
					case 5:
						
						variable = 5;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Complement(U, B);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						Resul.setText(Resultado.toString());
						break;
					case 6:
						variable = 6;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Union(A, B);
							Resultado=SetTheoryOperations.Complement(U, Resultado);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						Resul.setText(Resultado.toString());
						
						break;
					case 7:
						variable = 7;
						leerLosConjuntos();
						if(conjuntosCorrectos)
						{
							SetTheoryOperations.clearOperacion();
							Resultado=SetTheoryOperations.Intersection(A, B);
							Resultado=SetTheoryOperations.Complement(U, Resultado);
							//sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
							//startActivity(sendTo);
						}
						
						Resul = (EditText) findViewById(R.id.Resul);
						Resul.setText(Resultado.toString());
						break;	
				
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			
			}
			
		});
		
		boton.setOnClickListener(new View.OnClickListener() {
			
			@Override
		// creamos un metodo onClick para que envie los elementos de los EditText a otra actividad (Solve_solver)
			public void onClick(View v) {

	Intent sendTo;
				
				if (variable == 1)
				{
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Union(A, B);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}
					
				}
				if (variable == 2)
				{	
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Intersection(A, B);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}

				}
				if (variable == 3)
				{	
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Diference(A, B);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}

				}
				if (variable == 4)
				{	
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Complement(U, A);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}
				}
				if (variable == 5)
				{	
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Complement(U, B);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}
				}
				if (variable == 6)
				{	
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Union(A, B);
						Resultado=SetTheoryOperations.Complement(U, Resultado);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}
				}
				if (variable == 7)
				{	
					sendTo = new Intent(Solve_exercises.this, Solve_solver.class);
					leerLosConjuntos();
					if(conjuntosCorrectos)
					{
						SetTheoryOperations.clearOperacion();
						Resultado=SetTheoryOperations.Intersection(A, B);
						Resultado=SetTheoryOperations.Complement(U, Resultado);
						sendTo.putExtra("resultado", SetTheoryOperations.Operacion+Resultado.toString());
						startActivity(sendTo);
					}
				}
				
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
		
		if (U.containsAll(A)&&U.containsAll(B))
		{
			conjuntosCorrectos=true;
		}
		else
		{
			conjuntosCorrectos=false;
			Context context = getApplicationContext();
			CharSequence text = "El Universo debe de contener a A y a B";
			int duration = Toast.LENGTH_LONG;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();

		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.solve_exercises, menu);
		return true;
	}

}

