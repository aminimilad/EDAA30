package textproc;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
public class MultiWordCounter implements TextProcessor{

	int pos;
	Map<String, Integer> map = new HashMap<String, Integer>();
	public MultiWordCounter(String[] REGIONS) {
	
		for(String region : REGIONS) {
			map.put(region, 0);
		}
		
	}

	@Override
	public void process(String w) {
		
		if(map.containsKey(w)) {
			int pos = map.get(w);
			pos++;
			map.put(w,  pos);
		}
	}

	@Override
	public void report() {
		for(String i : map.keySet()) {
			System.out.print(i + ": " + map.get(i) + "\n");
		}
	}
	
}
