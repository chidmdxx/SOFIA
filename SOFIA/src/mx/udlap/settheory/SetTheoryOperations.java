package mx.udlap.settheory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetTheoryOperations {
	public static List<String> Resultado;
	public static String Operacion;
	
	public static void clearOperacion()
	{
		Operacion="La forma de llegar al resultado es:"+"\n";
	}
	
	public static List<String> Union (List<String> A, List<String>B)
	{
		List<String> toReturn=new ArrayList<String>();
		HashSet<String> hs=new HashSet<String>();
		hs.addAll(A);	
		hs.addAll(B);	
		toReturn.addAll(hs);
		Resultado=toReturn;
		Operacion=Operacion+A.toString()+" union " +B.toString()+"\n";
		return toReturn;
	}
	
	public static List<String> Union (List<List<String>> param)
	{
		//didn't use List.addall to prevent repeated values, something that doesn't happen in sets
		List<String> toReturn=new ArrayList<String>();
		HashSet<String> hs=new HashSet<String>();
		
		for (List<String> set : param)
		{
			hs.addAll(set);
			/*for(String value : set)
			{
				if(!toReturn.contains(value))
				{
					toReturn.add(value);
				}
			}*/
		}
		toReturn.addAll(hs);
		Resultado=toReturn;
		return toReturn;
	}
	
	public static List<String> Diference (List<String> minuend, List<String> subtrahend )
	{
		List<String> toReturn=new ArrayList<String>(minuend);
		toReturn.removeAll(subtrahend);
		Resultado=toReturn;
		Operacion=Operacion+minuend+" menos " +subtrahend+"\n";
		return toReturn;
	}
	
	public static List<String> Intersection (List<String> A, List<String> B)
	{
		List<String> toReturn=new ArrayList<String>();
		toReturn.addAll(A); // adds initial values to the result set
		toReturn.retainAll(B);
		Resultado=toReturn;
		Operacion=Operacion+A.toString()+" intersección " +B.toString()+"\n";
		return toReturn;
	}
	
	public static List<String> Intersection (List<List<String>> param)
	{
		List<String> toReturn=new ArrayList<String>();
		toReturn.addAll(param.get(0)); // adds initial values to the result set
		for (List<String> set : param)
		{
			toReturn.retainAll(set);
		}
		Resultado=toReturn;
		return toReturn;
	}
	
	public static List<String> Complement (List<String> U, List<String> A)
	{
		List<String> toReturn=new ArrayList<String>(U);
		toReturn.removeAll(A);
		Resultado=toReturn;
		Operacion=Operacion+A.toString()+" complemento, con universo " +U.toString()+"\n";
		return toReturn;
	}
}
