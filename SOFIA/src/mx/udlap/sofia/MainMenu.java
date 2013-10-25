package mx.udlap.sofia;

import com.example.sofia.Interfaz;
import com.example.sofia.Theory_description;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		//final Button conjuntos_teoria = (Button) findViewById(R.id.ImageButton01);
	
	/*
	conjuntos_teoria.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent sendTo = new Intent(MainMenu.this, Theory_description.class);
			startActivity(sendTo);
			
		}
	});*/
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	

}//hola!1!!
//hola!2¡
