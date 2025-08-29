package datastructures.standardlibrary;

import java.util.Queue;

class FibonacciExample {

    public static void main(String[] args) {
        fibonacci(10);
    }

    static void fibonacci(int target){
        int n1 = 0;
        int n2 = 1;
        System.out.print(n1 + " " + n2);
        int sum;
        for (int i = 2; i < target; ++i) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            if (sum == 1) continue;
            System.out.print(" " + sum);
        }
    }

    static int n1 = 0, n2 = 1, sum = 0;

    static void printFibonacci(int count) {
        if (count > 0) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            System.out.print(" " + sum);
            printFibonacci(count - 1);
        }
    }

}