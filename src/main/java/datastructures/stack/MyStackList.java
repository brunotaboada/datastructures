package datastructures.stack;

import java.util.ArrayList;

/**
 * @author bruno.taboada
 *
 * @param <E>
 */
public class MyStackList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1L;

    /**
     * @return e
     */
    public E pop() {
        E e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    /**
     * @param e
     */
    public void push(E e) {
        add(e);
    }

}