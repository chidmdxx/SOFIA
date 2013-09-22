package org.settheory.operations;

import java.util.ArrayList;
import java.util.List;

public class SetTheoryOperations {
	public static List<String> Union (List<List<String>> param)
	{
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
}
