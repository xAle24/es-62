package it.unibo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    /**
     *
     */
    private static final int START = 1000;
    private static final int ELEMS = 100_000;
    private UseListsAndMaps() {
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
        final List<Integer> list1 = new ArrayList<>();
        for (int i = START; i < 2000; i++) {
            list1.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> list2 = new LinkedList<Integer>(list1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int first = list1.get(0);
        list1.set(0, list1.get(list1.size() - 1));
        list1.set(list1.size() - 1, first);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer k:list1){
            System.out.println(k); 
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list1.add(i);
        }
        time = System.nanoTime() - time;
        System.out.println("array list" + time);
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list2.add(i);
        }
        time = System.nanoTime() - time;
        System.out.println("linked list:" + time);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            list1.get(ELEMS/2);
        }
        time = System.nanoTime() - time;
        System.out.println(time);
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
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa ", 1_110_635_000L);
        map.put("Americas ", 972_005_000L);
        map.put("Antartica ", 0L);
        map.put("Asia ", 4_298_723_000L);
        map.put("Europe ", 742_452_000L);
        map.put("Oceania ", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long pow = 0;
        for (final long i : map.values()){
            pow = pow + i; 
        }
    }
}
