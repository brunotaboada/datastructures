package testdome;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

	public static class TextInput {
		public List<Character> values = new ArrayList<>();

		public void add(char a) {
			values.add(a);
		}

		public String getValue() {
			StringBuilder result = new StringBuilder();
			for (Character val : values) {
				result.append(String.valueOf(val));
			}
			return result.toString();
		}
	}

	public static class NumericInput extends TextInput {
		@Override
		public void add(char a) {
			if (Character.isDigit(a)) {
				values.add(a);
			}
		}
	}

	public static void main(String[] args) {
		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('0');
		System.out.println(input.getValue());
	}

}