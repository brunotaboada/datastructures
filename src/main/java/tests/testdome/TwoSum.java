package tests.testdome;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class TwoSum {

	public static int[] findTwoSum(int[] list, int sum) {
		int[] result = null;
		Stack<Integer> stack = new Stack<>();
		List<Integer> ints = Arrays.stream(list).boxed().collect(Collectors.toList());
		stack.addAll(ints);
		root: while (!stack.isEmpty()) {
			int idx1 = stack.size() - 1;
			Integer number = stack.pop();
			for (int i = 0; i < stack.size(); i++) {
				Integer remainingElemen = stack.elementAt(i);
				if (number + remainingElemen == sum) {
					stack.clear();
					result = new int[] { idx1, i };
					break root;
				}
			}
			idx1--;
		}
		return result;
	}

	public static int[] findTwoSum2(int[] list, int sum) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < list.length; i++) {
			if (map.containsKey(sum - list[i])) {
				return new int[] { map.get(sum - list[i]), i };
			}
			map.put(list[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum2(new int[] { 3, 1, 1, 1, 1, 1 }, 10);
		if (indices != null) {
			System.out.println(indices[0] + " " + indices[1]);
		}
	}

}