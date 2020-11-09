package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final int FROM = 1000;
        final int TO = 2000;
    	
    	ArrayList<Integer> arrl = new ArrayList<>();
    	
    	for (int i=FROM; i<TO; i++) {
    		arrl.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	LinkedList<Integer> linl = new LinkedList<>();
    	linl.addAll(arrl);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final int FIRST = 0;
    	final int LAST = arrl.size()-1;
    	int temp;
    	
    	temp = arrl.get(FIRST);
    	arrl.set(FIRST, arrl.get(LAST));
    	arrl.set(LAST, temp);  
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (int elem : arrl) {
    		System.out.println(elem);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	final int ELEMS = 100_000;
        final int TO_MS = 1_000_000;
        final int POS = 0;
        
    	long time = System.nanoTime();
    	
    	for (int i = 1; i <= ELEMS; i++) {
            arrl.add(POS, i);
            linl.add(POS, i);
        }
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println((time / TO_MS + " ms"));
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	final int mid = arrl.size()/2;
    	
    	time = System.nanoTime();
    	
    	for (int i=0; i<1000; i++) {
    		arrl.get(mid);
    		linl.get(mid);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println((time / TO_MS + " ms"));
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	TreeMap<String,Long> world = new TreeMap<>();
    	
    	world.put("Africa", 1_110_635_000L);
    	world.put("Americas", 972_005_000L);
    	world.put("Antartica", 0L);
    	world.put("Asia", 4_298_723_000L);
    	world.put("Europe", 742_452_000L);
    	world.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	long wpop = 0;
    	
    	for (long elem : world.values()) {
    		wpop = wpop + elem;
    	}
    	
    	System.out.println(wpop);
    }
}
