package mx.udlap.equations;

import mx.udlap.sofia.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Equation_solver extends Activity {
	EquationMethods methods = new EquationMethods();
	Equation_Methods2 methods2 = new Equation_Methods2();
	public String equation,Resultado;
	public int a,b,c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equation_solver);
		
		//Elements
		Button solver = (Button) findViewById(R.id.equation_solverB);
		Button graphic = (Button) findViewById(R.id.equation_graphicB);
		Button resultB = (Button) findViewById(R.id.equation_ResultB);
		final TextView result = (TextView) findViewById(R.id.solver_Result);
		final EditText eq = (EditText) findViewById(R.id.ecuation_textField);
		
		
		//Click listener
		solver.setOnClickListener(new View.OnClickListener() { //Boton Paso a Paso
			@Override
			public void onClick(View v) {
				setValues(eq);
				if (methods2.validacion(a, b, c)){
				Intent sendTo = new Intent(Equation_solver.this, mx.udlap.equations.Equation_solver_answer.class);
				
				setValues(eq);
				/*xy.setText(methods.PasoaPaso(a, b, c));
				eq.setText("");*/
				
				Resultado = methods.PasoaPaso(a, b, c, equation);
				sendTo.putExtra("result", Resultado);
				startActivity(sendTo);
				}
				else{
					new AlertDialog.Builder(Equation_solver.this).setTitle("Alerta!")
            		.setMessage("La ecuacion esta mal escrita.").setNeutralButton("Volver a intentar.",
            		new DialogInterface.OnClickListener() {
            			public void onClick(DialogInterface dialog,int which) {
            		}
            		}).show();
				}
			}
		});
		
		graphic.setOnClickListener(new View.OnClickListener() { //Boton Graficar
			@Override
			public void onClick(View v) {
				setValues(eq);
				if (methods2.validacion(a, b, c)){
					Intent sendTo_graphic = new Intent(Equation_solver.this, mx.udlap.equations.Equation_graphic.class);
					equation = eq.getText().toString();
					sendTo_graphic.putExtra("equation", equation);
					startActivity(sendTo_graphic); 
				}
				else{
					new AlertDialog.Builder(Equation_solver.this).setTitle("Alerta!")
            		.setMessage("La ecuacion esta mal escrita.").setNeutralButton("Volver a intentar.",
            		new DialogInterface.OnClickListener() {
            			public void onClick(DialogInterface dialog,int which) {
            		}
            		}).show();
				}
			}
		});
	
		resultB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setValues(eq);
				if (methods2.validacion(a, b, c)){
					equation = eq.getText().toString();
					result.setText(methods.getX1X2(equation).toString());
				}
				else{
					new AlertDialog.Builder(Equation_solver.this).setTitle("Alerta!")
            		.setMessage("La ecuacion esta mal escrita.").setNeutralButton("Volver a intentar.",
            		new DialogInterface.OnClickListener() {
            			public void onClick(DialogInterface dialog,int which) {
            		}
            		}).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.ecuations, menu);
		return true;
	}
	
	private void setValues(EditText eq){
		equation = eq.getText().toString();
		a = methods.getA(equation);
		b = methods.getB(equation);
		c = methods.getC(equation);
	}

}
