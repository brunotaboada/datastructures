package interviewcake;

public class Fibonnaci {

  public static void main(String[] args) {
    //O(n) time and O(1)O(1) space.
    System.out.println(fib(8));
    //O(n^2)
    System.out.println(fibRecurssion(8));
  }

  public static int fib(int n) {

    if (n < 0) {
      throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
    } else if (n == 0 || n == 1) {
      return n;
    }

    // we'll be building the fibonacci series from the bottom up
    // so we'll need to track the previous 2 numbers at each step
    int first = 0; // 0th fibonacci
    int second = 1; // 1st fibonacci
    int third = 0; // Declare and initialize third

    for (int i = 1; i < n; i++) {
      // Iteration 1: third = 2nd fibonacci
      // Iteration 2: third = 3rd fibonacci
      // Iteration 3: third = 4th fibonacci
      // To get nth fibonacci ... do n-1 iterations.
      third = second + first;
      first = second;
      second = third;
    }

    return third;
  }

  public static int fibRecurssion(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }

}
