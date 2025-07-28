package demo;

import java.util.*;

class GFG {

    static int getPairsCount(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int ele : arr) {
            int targetElement = k - ele;
            if (m.containsKey(targetElement))
                count += m.get(targetElement);
            m.computeIfPresent(ele, (key, value) -> value + 1);
            m.computeIfAbsent(ele, integer -> 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        System.out.print("Count of pairs is " + getPairsCount(arr, sum));
    }
}


