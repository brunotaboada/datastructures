package demo;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

  //Nice way to get the intersection
  public void intersection(String[] args) {
    int[] ar = new int[]{3, 5, 7};
    int[] ar2 = new int[]{1, 3, 5, 7, 11, 5};

    int a = 0;
    int b = 0;

    while (a < ar.length && b < ar2.length){
      if(ar[a] < ar2[b]){
        a++;
      } else if (ar2[b] < ar[a]){
        b++;
      } else {
        System.out.println(ar2[b++]+"");
        a++;
      }
    }

    //System.out.println(fib(10));
  }

  void b(int arr[]) {
    Collections.sort(new ArrayList<String>());
  }

  private static void quickSort (int[] array, int left, int right) {
    int index = partition(array, left, right);

    //Sort left half
    if (left < index - 1)
      quickSort(array, left, index - 1);

    //Sort right half
    if (index < right)
      quickSort(array, index , right);
  }

  private static int partition (int array[], int left, int right) {
    int pivot = array[(left + right) / 2]; //Pick pivot point
    while (left <= right) {
      //Find element on left that should be on right
      while (array[left] < pivot)
        left++;

      //Find element on right that should be on left
      while (array[right] > pivot)
        right--;

      //Swap elements and move left and right indices
      if (left <= right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
        right--;
      }
    }
    return left;
  }

  void ss(int arr[]) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int actual = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] < actual) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = actual;
    }
  }

  void is(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++)
        if (arr[j] < arr[min_idx])
          min_idx = j;

      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // Driver code to test above
  public static void main(String args[]) {
    Test ob = new Test();
    int arr[] = {64, 25, 12, 22, 11};
    ob.ss(arr);
    System.out.println("Sorted array");
    ob.printArray(arr);
  }


}