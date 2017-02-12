package datastructures.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author bruno.taboada
 */
public class MainGeneral {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        LinkedList<String> linkedlist = new LinkedList<>();

        Map<Integer, String> map = new HashMap<>();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>(); // sorted

        HashSet<Integer> hset = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>(); // sorted

        Stack<Integer> stack = new Stack<>();
        Queue<String> que = new LinkedList<>();

        int number = 12345;
        int res = 0, mod = 0;
        int middle = number;
        while (middle > 0) {
            mod = middle % 10;
            res = res * 10 + mod;
            middle = middle / 10;
        }

        System.out.println(res);

    }

}