package mx.udlap.settheory;

import java.util.ArrayList;
import java.util.List;

public class SetTheoryOperations {
	public static List<String> Union (List<List<String>> param)
	{
		//didn't use List.addall to prevent repeated values, something that doesn't happen in sets
		List<String> toReturn=new ArrayList<String>();
		for (List<String> set : param)
		{
			for(String value : set)
			{
				if(!toReturn.contains(value))
				{
					toReturn.add(value);
				}
			}
		}
		return toReturn;
	}
	
	public static List<String> Diference (List<String> minuend, List<String> subtrahend )
	{
		minuend.removeAll(subtrahend);
		return minuend;
	}
	
	public static List<String> Intersection (List<List<String>> param)
	{
		List<String> toReturn=new ArrayList<String>();
		toReturn.addAll(param.get(0)); // adds initial values to the result set
		for (List<String> set : param)
		{
			toReturn.retainAll(set);
		}
		return toReturn;
	}
	
	public static List<String> Complement (List<String> universe, List<String> a)
	{
		universe.removeAll(a);
		return universe;
	}
}
