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
private String equation;
private int size,menorX,aR,bR,a,b,c,menorY=0,mayorY=0,max;
private Number[] x = new Number[size];
private Number[] y = new Number[size];
private int[] xx = new int[size];
private int[] yy = new int[size];

private double x1,x2;

	
	 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_graphic);
        
        // initialize our XYPlot reference:
        //mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        
        // Obtenemos los datos de nuestra otra actividad y lo asignamos al EditText (Resultado)
     	Bundle extras1 = getIntent().getExtras();
     	if (extras1 != null){
     		String result = extras1.getString("equation");
     		equation = result;
     		x1 = methods.getX1(methods.getA(equation), methods.getB(equation), methods.getC(equation));
     		x2 = methods.getX2(methods.getA(equation), methods.getB(equation), methods.getC(equation));
     		//Obtains the size of the arrays X[] and Y[]
     		size = methods.getArraySize(x1, x2);
     		
     		final Number[] xArray = new Number[size];
     		final Number[] yArray = new Number[size];
     		final int[] xxArray = new int[size];
     		final int[] yyArray = new int[size];
     		
     		x = xArray;
     		y = yArray;
     		xx = xxArray;
     		yy = yyArray;
     	}
     	for (int i=0; i<xx.length; i++)
     		max = i;
     	
     	// initialize our XYPlot reference:
        mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        
        // Create a couple arrays of y-values to plot:
        //Number[] series1Numbers = {35, 24, 15, 8, 3, 0, -1, 0, 3, 8, 15, 24, 35};
        //Number[] xValues = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        menorX = methods.getMenorX(x1, x2);
        for (int i=0; i<x.length; i++){
        	x[i] =  menorX;
        	xx[i] = menorX;
        	menorX++;
        }
        
        /*for (int i=0; i<y.length; i++){
        	y[i] = i;
        }*/
        
        for (int i=0; i<x.length; i++){
            aR=methods.getA(equation)*(xx[i]*xx[i]);
            bR=methods.getB(equation)*(xx[i]);
            y[i]=aR+bR+methods.getC(equation);
            yy[i]=aR+bR+methods.getC(equation);
            if (yy[i]<menorY){
            	menorY=yy[i];
            }
        }
        
        for (int i=0; i<y.length; i++){
        	if (yy[i]>mayorY)
        		mayorY=yy[i];
        }
        
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(x),          // SimpleXYSeries takes a List so turn our array into a List
                Arrays.asList(y), // Y_VALS_ONLY means use the element index as the x value
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
        //mySimpleXYPlot.setRangeBoundaries(menorY-5, yy[0]+5, BoundaryMode.FIXED); //Set the X Boundaries
        //mySimpleXYPlot.setDomainBoundaries(xx[0]-5, xx[max]+5, BoundaryMode.FIXED ); //Set the Y Boundaries
        mySimpleXYPlot.setRangeBoundaries(menorY-5, mayorY+5, BoundaryMode.FIXED); //Set the X Boundaries
        mySimpleXYPlot.setDomainBoundaries(x1-5, x2+5, BoundaryMode.FIXED ); //Set the Y Boundaries
        
        //Extras
        //mySimpleXYPlot.setTitle("X1 = 4.0 / X2 = 2.0");
        mySimpleXYPlot.setTitle(methods.getX1X2(equation));
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
