package datastructures.list;

import java.util.Arrays;

/**
 * @author bruno.taboada
 *
 * @param <E>
 */
public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    /**
     * 
     */
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * @param e
     */
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    /**
     * @param i
     * @return elements[i]
     */
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
}