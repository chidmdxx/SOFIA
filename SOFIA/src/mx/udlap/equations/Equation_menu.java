package mx.udlap.equations;

import mx.udlap.sofia.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Equation_menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equation_menu);
		//Elements
		Button solver = (Button) findViewById(R.id.equation_menu_solverB);
		Button theory = (Button) findViewById(R.id.equation_menu_theoryB);
		
		//Click listener
		solver.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent ecuations_solver = new Intent(Equation_menu.this, mx.udlap.equations.Equation_solver.class);
				startActivity(ecuations_solver);
			}
		});
		
		theory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent ecuations_theory = new Intent(Equation_menu.this, mx.udlap.equations.Equation_theory.class);
				startActivity(ecuations_theory);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ecuations_menu, menu);
		return true;
	}

}
