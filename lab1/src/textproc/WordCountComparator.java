package textproc;

import java.util.*;
import java.util.Map.Entry;

public class WordCountComparator implements Comparator<Map.Entry<String,Integer>> 
{

	@Override
	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		
		if(o1.getValue().equals(o2.getValue())) {
			return o1.getKey().compareTo(o2.getKey());
 
		}
		
		else {
			return o2.getValue() - o1.getValue();
		}
		
		
		

		
	}

}
	

