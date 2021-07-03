package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		 // kod vars exekveringstid vi vill mäta
		

		ArrayList<TextProcessor> TP = new ArrayList<TextProcessor>();
	
		
		
		TP.add(0, new SingleWordCounter("nils"));
		TP.add(1, new SingleWordCounter("norge"));
		
		TextProcessor r = new MultiWordCounter(REGIONS);
		TP.add(2, r);
		
		Set<String> stopWords = new HashSet<String>();
		TextProcessor tpr = new GeneralWordCounter(stopWords);
		TP.add(3, tpr);
		int n=3;
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();

			
			stopWords.add(word);	
			
			
		}
		
		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for(int i = 0; i<= n; i++) {
				TP.get(i).process(word);
			}
			
		}

		
		s.close();

		for(int i = 0; i<= n; i++) {
			TP.get(i).report();
		}
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}