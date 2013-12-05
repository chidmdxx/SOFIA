package com.example.sofiaTriangulo;


import mx.udlap.sofia.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Triangulo extends Activity {

     //Double fas = editText1;
	// Double editText2;
	// Double editText3;
	EditText A1,B1,C1, Alfa1, Beta1, Gamma1;
	Button bRespuesta, bPasos, bVersion, bBorrar;
	TextView etiquetaRespuesta, etiquetaRespuesta2;
	double[] G;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
    
    etiquetaRespuesta = (TextView) findViewById(R.id.solver_Result);
    bRespuesta = (Button) findViewById(R.id.equation_ResultB);
    bPasos = (Button) findViewById(R.id.equation_menu_theoryB);
    bBorrar = (Button) findViewById(R.id.button4);
    etiquetaRespuesta2 = (TextView) findViewById(R.id.textResult);
    //final TriangleSolver tri;
    
     A1 = (EditText) findViewById(R.id.editText1);
     B1 = (EditText) findViewById(R.id.editText3);
     C1 = (EditText) findViewById(R.id.editText2);
     Alfa1 = (EditText) findViewById(R.id.editText4);
     Beta1 = (EditText) findViewById(R.id.editText5);
     Gamma1 = (EditText) findViewById(R.id.editText6);
     
     View.OnClickListener vista = new  View.OnClickListener()
     {

		@Override
		public void onClick(View v)
		{
			switch (v.getId()) 
			{

            case R.id.button3: 
                // doStuff
                setContentView(R.layout.activity_triangle);
                break;
            case R.id.button4: 
                // doStuff
                setContentView(R.layout.activity_triangle);
                break;
			}
		}
    	 
     };
		findViewById(R.id.button3).setOnClickListener(vista);
		
	bBorrar.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) 
		{

			A1.setText("");
			B1.setText("");
			C1.setText("");
			Alfa1.setText("");
			Beta1.setText("");
			Gamma1.setText("");
		}
	});
     
     bRespuesta.setOnClickListener(new View.OnClickListener() {
		
		//@SuppressWarnings("null")
		//@Override
		@SuppressWarnings("null")
		public void onClick(View v) 
		{
			
			String A11 = A1.getText().toString();
			String B22 = B1.getText().toString();
			String C33 = C1.getText().toString();
			String Alfa11 = Alfa1.getText().toString();
			String Beta22 = Beta1.getText().toString();
			String Gamma33 = Gamma1.getText().toString();
			
			double A = EsNull(A11);
			double B = EsNull(B22);
			double C = EsNull(C33);
			double Alfa = EsNull(Alfa11);
			double Beta = EsNull(Beta22);
			double Gamma = EsNull(Gamma33);
			/*double C = Double.valueOf(C33).doubleValue();
			double Alfa = Double.valueOf(Alfa11).doubleValue();
			double Beta = Double.valueOf(Beta22).doubleValue();
			double Gamma = Double.valueOf(Gamma33).doubleValue();*/
			
			
			if(validacion(A,B,C,Alfa,Beta,Gamma))
			{
				String info = "los lados si forman un tringulo";
				etiquetaRespuesta.setText(info);
				TriangleSolver tri = null;
				G = tri.solver(A, B, C, Alfa, Beta, Gamma);
				System.out.print(G);
				A1.setText(String.valueOf((G[0])));
				B1.setText(String.valueOf((G[1])));
				C1.setText(String.valueOf((G[2])));
				Alfa1.setText(String.valueOf((float)(G[3])));
				Beta1.setText(String.valueOf((float)(G[4])));
				Gamma1.setText(String.valueOf((float)(G[5])));
				bPasos.setVisibility(View.VISIBLE);
				bBorrar.setVisibility(View.VISIBLE);
				

				
			
			}
			
			else
			{
				String info = "los datos que diste no forman un triangulo, vuelve a intentarlo";
				etiquetaRespuesta.setText(info);
			}
			
		}

		public boolean validacion(double a, double b, double c, double alfa, double beta, double gamma) {
			if((a+b)>c & (b+c)>a & (a+c)>b || a > 0 & b >0 &  alfa > 0 || a > 0 & c >0 &  alfa > 0||a > 0 & c >0 &  alfa > 0 ||a > 0 & b >0 &  beta > 0 ||a > 0 & c >0 &  beta > 0 ||a > 0 & b >0 &  gamma > 0 ||  alfa + beta+ gamma == 180 )
				{
					return true;
				}
			
			
			else
			{
				return false;
			}
		}

		@SuppressLint("NewApi")
		private double EsNull(String variable) 
		{
			if (variable == null || variable.isEmpty())
			{
				return 0 ;
			}
			else
			{
				 return  Double.valueOf(variable).doubleValue();
			}

			
		}
	});
    

    /*bRespuesta.setOnClickListener(new View.OnClickListener() 
    {
		@Override
		public void onClick(View arg0) 
		{

			String A11 = A1.getText().toString();
			String B22 = B1.getText().toString();
			String C33 = C1.getText().toString();
			
			double A = Double.valueOf(A11).doubleValue();
			double B = Double.valueOf(B22).doubleValue();
			double C = Double.valueOf(C33).doubleValue();
			
			
			if(abs(A-C)<B)
			{
				String info = "los lados si forman un tringulo";
				etiquetaRespuesta.setText(info);
			}
			else
			{
				String info = "los datos que diste no forman un triangulo, vuelve a intentarlo";
				etiquetaRespuesta.setText(info);
			}
			
		}
		
	}
    );*/
    }


    //@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    
}
