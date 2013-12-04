package mx.udlap.equations;

import mx.udlap.sofia.R;
import mx.udlap.sofia.R.layout;
import mx.udlap.sofia.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Equation_theory extends Activity {
	Equation_theoryValues eq = new Equation_theoryValues();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equation__theory);
		TextView def1 = (TextView) findViewById(R.id.equation_definicion1);
		TextView def2 = (TextView) findViewById(R.id.equation_definicion2);
		TextView def4 = (TextView) findViewById(R.id.equation_definicion4);
		
		def1.setText(eq.definition1());
		def2.setText(eq.definition2());
		def4.setText(eq.definition4());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.equation__theory, menu);
		return true;
	}

}
