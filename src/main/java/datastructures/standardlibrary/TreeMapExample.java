package datastructures.standardlibrary;

import java.util.TreeMap;

/**
 * @author bruno.taboada
 */
public class TreeMapExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TreeMap<Integer, String> RBtree = new TreeMap<>();
        RBtree.put(3, "Third");
        RBtree.put(5, "Fifith");
        RBtree.put(2, "Second");
        RBtree.put(10, "Ten");

        RBtree.forEach((k, v) -> System.out.println(k + v));
    }

}