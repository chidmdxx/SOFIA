package mx.udlap.settheory;

import mx.udlap.sofia.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Seeanswer_exercises extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seeanswer_exercises);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seeanswer_exercises, menu);
		return true;
	}

}
