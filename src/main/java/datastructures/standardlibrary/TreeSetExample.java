package datastructures.standardlibrary;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author bruno.taboada
 */
public class TreeSetExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("That's tree set. It is based on red black tree data structure.");
        System.out.println("Major advantages are:");
        System.out.println("It keeps the elements in order.");
        System.out.println("Time complexity is O(log n) for basic operations (access,insert,search,remove)");

        Comparator<Integer> cmp = (e1, e2) -> e1.compareTo(e2);

        TreeSet<Integer> tree = new TreeSet<Integer>(cmp);
        tree.add(34);
        tree.add(63);
        tree.add(12);
        tree.add(45);

        // here it test it's sorted, 63 is the last element. see output below
        // Displaying the Tree set data
        tree.stream().forEach(System.out::println);

        // Check empty or not
        if (tree.isEmpty()) {
            System.out.print("Tree Set is empty.");
        } else {
            System.out.println("Tree Set size: " + tree.size());
        }

        // Retrieve first data from tree set
        System.out.println("First data: " + tree.first());

        // Retrieve last data from tree set
        System.out.println("Last data: " + tree.last());

        if (tree.remove(45)) { // remove element by value
            System.out.println("Data is removed from tree set " + 45);
        } else {
            System.out.println("Data doesn't exist!");
        }

        System.out.println("Now the tree set contain: ");

        // Displaying the Tree set data
        tree.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Now the size of tree set: " + tree.size());

        // Remove all
        System.out.print("Invoking tree.clear()");
        tree.clear();
        if (tree.isEmpty()) {
            System.out.print("Tree Set is empty.");
        } else {
            System.out.println("Tree Set size: " + tree.size());
        }
    }
}