package datastructures.map;

public class Entry<K, V> {
    public K key;

    public Entry(K key, V val) {
        super();
        this.key = key;
        this.val = val;
    }

    public V val;
    public Entry<K, V> next;
}