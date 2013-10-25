package com.example.sofia;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import mx.udlap.sofia.R;

public class Theory_exercises extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theory_exercises);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.theory_exercises, menu);
		return true;
	}

}
