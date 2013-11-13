package mx.udlap.equations;

import mx.udlap.sofia.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Equation_solver extends Activity {
	EquationMethods methods = new EquationMethods();
	public String equation,Resultado;
	public int a,b,c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equation_solver);
		
		//Elements
		Button solver = (Button) findViewById(R.id.equation_solverB);
		Button graphic = (Button) findViewById(R.id.equation_graphicB);
		final EditText eq = (EditText) findViewById(R.id.ecuation_textField);
		final TextView xy = (TextView) findViewById(R.id.ecuation_xy);
		
		
		//Click listener
		solver.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sendTo = new Intent(Equation_solver.this, mx.udlap.equations.Equation_solver_answer.class);
				
				equation = eq.getText().toString();
				a = methods.getA(equation);
				b = methods.getB(equation);
				c = methods.getC(equation);
				/*xy.setText(methods.PasoaPaso(a, b, c));
				eq.setText("");*/
				
				Resultado = methods.PasoaPaso(a, b, c, equation);
				sendTo.putExtra("result", Resultado);
				startActivity(sendTo);
			}
		});
		
		graphic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sendTo_graphic = new Intent(Equation_solver.this, mx.udlap.equations.Equation_graphic.class);
				sendTo_graphic.putExtra("equation", equation);
				startActivity(sendTo_graphic); 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ecuations, menu);
		return true;
	}

}
