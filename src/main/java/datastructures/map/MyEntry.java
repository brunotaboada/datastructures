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
}
