package demo;

import java.util.*;

class GFG {

    static int getPairsCount(int arr[], int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5};
        int sum = 6;
        System.out.print("Count of pairs is " + getPairsCount(arr, arr.length, sum));
    }
}


