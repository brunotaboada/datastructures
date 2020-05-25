package tests.testdome;
import java.util.Arrays;

public class SortedSearch {

	public static int countNumbers(int[] sortedArray, int lessThan) {
		int value = Arrays.binarySearch(sortedArray, lessThan);
		if (value < 0) {
			return Math.abs(value) - 1;
		} else {
			return Math.abs(value);
		}
	}

	public static void main(String[] args) {
		System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 7));
	}
}