package datastructures.standardlibrary;

import java.util.*;

/**
 * @author bruno.taboada
 */
public class MainGeneral {

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        LinkedList<String> lkl = new LinkedList<>();
        Map<Integer, String> map = new HashMap<>();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>(); // sorted
        HashSet<Integer> hset = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>(); // sorted
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        Queue<String> que = new LinkedList<>();
        Deque<Integer> stackDeque = new ArrayDeque<>();
    }

}