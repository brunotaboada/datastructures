package testdome;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	Set<String> resultado = new HashSet<>();
    	extracted(names1, resultado);
    	extracted(names2, resultado);
    	return resultado.toArray(new String[]{});
    }

	private static void extracted(String[] array, Set<String> resultado) {
		for (int i = 0; i < array.length; i++) {
			String string = array[i];
			resultado.add(string);
		}
	}
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
    
}