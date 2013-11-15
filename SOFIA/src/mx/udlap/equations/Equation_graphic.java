package mx.udlap.equations;


import java.util.Arrays;

import com.androidplot.xy.*;
import mx.udlap.sofia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Equation_graphic extends Activity {

EquationMethods methods = new EquationMethods();
private XYPlot mySimpleXYPlot;
private String equation = "x^2-6x+8=0";
	
	 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_graphic);
        
        // initialize our XYPlot reference:
        //mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        
        // Obtenemos los datos de nuestra otra actividad y lo asignamos al EditText (Resultado)
     	Bundle extras = getIntent().getExtras();
     	if (extras != null){
     		String resultado = extras.getString("equation");
     		
     		// initialize our XYPlot reference:
            mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
     		mySimpleXYPlot.setTitle(resultado);
     	}

        
       
        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {35, 24, 15, 8, 3, 0, -1, 0, 3, 8, 15, 24, 35};
        Number[] xValues = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(xValues),          // SimpleXYSeries takes a List so turn our array into a List
                Arrays.asList(series1Numbers), // Y_VALS_ONLY means use the element index as the x value
                equation); 

        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_plf2);


        // add a new series' to the xyplot:
        mySimpleXYPlot.addSeries(series1, series1Format);


        // reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(1);
        mySimpleXYPlot.setRangeBoundaries(-3, 38, BoundaryMode.FIXED); //Set the X Boundaries
        mySimpleXYPlot.setDomainBoundaries(-5, 10, BoundaryMode.FIXED ); //Set the Y Boundaries
        
        //Extras
        //mySimpleXYPlot.setTitle("X1 = 4.0 / X2 = 2.0");
        mySimpleXYPlot.setDomainLabel("X");
        mySimpleXYPlot.setRangeLabel("Y");
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.equation_graphic, menu);
		return true;
	}

}
