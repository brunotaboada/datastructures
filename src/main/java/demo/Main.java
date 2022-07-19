package demo;


import java.util.*;

public class Main {

  public static Integer arrayChallenge(int[] arr) {
    Map<Integer, Integer> counts = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    int high = 0;
    int higher = 0;

    for(int i = 0; i < arr.length; i++){
      Integer val = counts.get(arr[i]);
      if(val != null){
        val++;
        counts.put(arr[i], val);
        stack.add(arr[i]);
        if(high < val){
          high = val;
          higher = arr[i];
        }
      } else {
        counts.put(arr[i], 1);
      }
    }
    if(stack.isEmpty()){
      return -1;
    } else {
      return stack.firstElement() == higher ? stack.firstElement() : higher;
    }
  }

  public static boolean StringChallenge(String str1, String str2) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < str1.length(); i++){
      set.add(str1.charAt(i));
    }

    for(int k = 0; k < str2.length(); k++ ){
      if(!set.contains(str2.charAt(k))){
        return false;
      }
    }

    return true;
  }

  public static void main (String[] args) {
    System.out.println(arrayChallenge(new int[] {5, 5, 1, 5, 1, 11, 11, 11}));
  }


}