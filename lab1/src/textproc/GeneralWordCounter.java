package textproc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;


public class GeneralWordCounter implements TextProcessor{

	Set<String> stopwords = new HashSet<String>();
	Map<String, Integer> map = new HashMap<String, Integer>();
	public GeneralWordCounter(Set<String> list) {
		stopwords = list;
	}
	@Override
	public void process(String w) {
		if(!stopwords.contains(w)) {
			
			if(!map.containsKey(w)) {
				map.put(w, 1);
				
			}
			
			else {
				map.put(w, map.get(w)+1);
			}
			
		}
		
	}
	public Set<Map.Entry<String, Integer>> getWords() {
		
		return map.entrySet();
	}


	@Override
	public void report() {
		
		Map<String, Integer> counts = map;
		Set<Map.Entry<String, Integer>> wordSet = counts.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		
		
		wordList.sort(new WordCountComparator());

		for(int i = 0; i<10; i++) {
			System.out.print(wordList.get(i) + "\n");
		}
		/*
		for(String key : map.keySet()) {
			if(map.get(key) >= 200) {
				System.out.print(key + " "+ map.get(key) + "\n");
			}
		}*/
		
	}

}
