package datastructures.map;

/**
 * @author bruno.taboada
 *
 * @param <K>
 * @param <V>
 */
public class MyEntry<K, V> {
    private final K key;
    private V value;
    private MyEntry<K, V> next = null;

    /**
     * @param key
     * @param value
     */
    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * @return value
     */
    public V getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * @return the next
     */
    public MyEntry<K, V> getNext() {
        return next;
    }

    /**
     * @param next
     *            the next to set
     */
    public void setNext(MyEntry<K, V> next) {
        this.next = next;
    }
}
