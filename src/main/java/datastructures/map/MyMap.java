package datastructures.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bruno.taboada
 *
 * @param <K>
 * @param <V>
 */
public class MyMap<K, V> {

    private int size;
    private int DEFAULT_CAPACITY = 16;
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] bucket = new Entry[DEFAULT_CAPACITY];

    /**
     * @param key
     * @return value
     */
    public V get(K key) {
        Entry<K, V> ele = bucket[hash(key)];
        V result = null;
        while (ele != null) {
            if (ele.key.equals(key)) {
                result = ele.val;
                break;
            }
            ele = ele.next;
        }
        return result;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) & (DEFAULT_CAPACITY - 1);
    }

    public V put(K key, V value) {

        Entry<K, V> entry = new Entry<K, V>(key, value);

        ensureCapa();

        int hash = hash(key);

        if (bucket[hash] == null) {
            bucket[hash] = entry;
            size++;
        } else {
            Entry<K, V> curr = bucket[hash];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    bucket[hash] = entry;
                    return value;
                } else if (curr.next == null) {
                    curr.next = entry;
                    return value;
                }
                curr = curr.next;
            }
        }
        return value;
    }

    private void ensureCapa() {
        if (size == bucket.length) {
            int newSize = bucket.length * 2;
            DEFAULT_CAPACITY = newSize;
            bucket = Arrays.copyOf(bucket, newSize);
        }
    }

    /**
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * @param key
     */
    public void remove(K key) {
        for (int i = 0; i < size; i++) {
            if (bucket[i].key.equals(key)) {
                bucket[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            bucket[i] = bucket[i + 1];
        }
    }

    /**
     * @return value
     */
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < size; i++) {
            set.add(bucket[i].key);
        }
        return set;
    }
}