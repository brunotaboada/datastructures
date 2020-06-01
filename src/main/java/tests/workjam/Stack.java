package tests.workjam;

import java.util.Arrays;

public class Stack {

	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Long elements[];

	/**
	 * 
	 */
	public Stack() {
		elements = new Long[DEFAULT_CAPACITY];
	}

	/**
	 * @param put a element on top of the stack.
	 */
	public void push(Long e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}

	/**
	 * @return the topmost element
	 */
	public Long pop() {
		if(this.size == 0)
			return null;
		Long e =  elements[--size];
		elements[size] = null;
		return e;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}


	public static void main(String[] args) {
		final Stack stack = new Stack();
		System.out.println(stack.pop());
	}
}