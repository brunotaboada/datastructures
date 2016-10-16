package datastructures.stack;

import java.util.Arrays;

/**
 * @author bruno.taboada
 * @param <E>
 */
public class MyStackArray<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    /**
     * 
     */
    public MyStackArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * @param put
     *            a element on top of the stack.
     */
    public void push(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    /**
     * @return the topmost element
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}