package mx.udlap.equations;

import mx.udlap.sofia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Equation_solver_answer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equation_solver_answer);
		// Obtenemos los datos de nuestra otra actividad y lo asignamos al EditText (Resultado)
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			String resultado = extras.getString("result");
			//Elements
			TextView answer = (TextView) findViewById(R.id.equationAnswer);
			
			answer.setText(resultado);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.equation_solver_answer, menu);
		return true;
	}

}
