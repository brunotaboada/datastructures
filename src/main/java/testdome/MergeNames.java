package testdome;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	Set<String> resultado = new HashSet<>();
    	for (int i = 0; i < names1.length; i++) {
			String string1 = names1[i];
			resultado.add(string1);
		}
    	for (int i = 0; i < names2.length; i++) {
			String string2 = names2[i];
			resultado.add(string2);
		}
    	return resultado.toArray(new String[]{});
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}