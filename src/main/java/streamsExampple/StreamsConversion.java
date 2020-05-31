package streamsExampple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsConversion {

	public static void main(String[] args) {

		/**** Converting a Primitive 'int' Array to List ****/
		int intArray[] = { 1, 2, 3, 4, 5 };
		List<Integer> integerList1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		System.out.println("List #1: " + integerList1);

		/**** Creating a map java 9 ****/
		Map<String, String> map2 = Map.of("k1", "v1", "k2", "v2", "k3", "v3");
		System.out.println("List #1: " + map2);

		Map<Integer, Integer> map = integerList1.stream().collect(Collectors.toMap(value -> value, value -> value));
		System.out.println(map);

		List<String> hostingProviders = Arrays.asList("Bluehost", "GoDaddy", "Amazon AWS", "LiquidWeb", "FatCow");
		Map<String, String> cards2Length = hostingProviders.stream().collect(
				Collectors.toMap(Function.identity(), Function.identity(), (e1, e2) -> e2, LinkedHashMap::new));

		// create a list
		List<String> lt = new ArrayList<>();

		// add the member of list
		lt.add("Geeks1");
		lt.add("For");
		lt.add("Geeks");
		lt.add("GeeksForGeeks");

		// create multimap and store the value of list
		Map<Integer, String> studentsMap = lt.stream().collect(Collectors.toMap(String::length, val -> val));

		// create a list
		List<String> lt2 = new ArrayList<>();

		// add the member of list
		lt2.add("Geeks");
		lt2.add("For");
		lt2.add("Geeks");
		lt2.add("GeeksForGeeks");
		Map<String, String> studentsMap2 = lt2.stream()
				.collect(Collectors.toMap(Function.identity(), Function.identity(), (oldValue, newValue) -> oldValue));

		System.out.println("new list: " + studentsMap2);

	}

}