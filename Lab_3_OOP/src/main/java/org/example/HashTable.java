package org.example;

import java.lang.Math;

public class HashTable< K, V > {

    private static final int DEFAULT_CAPACITY = 4;
    private static final double LOAD_FACTOR = 0.75;
    Entry<K, V>[] table; // Array of buckets in each buckets is located a singleLinkedList
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }

    public static class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void printTable() {
        if (table == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry<K, V> curr = table[i];
                while (curr != null) {
                    System.out.print("Key: " + curr.key + "  Value: " + curr.value + "\n");
                    curr = curr.next;
                }
            }
        }
    }

    public void put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }

        if (size > LOAD_FACTOR * table.length){
            resize();
        }

        int index = hash(key);
        if (table[index] == null) {
            // if the bucket is empty we create a new entry
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            Entry<K, V> entry = table[index];
            while (true) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }

                if (entry.next == null) {
                    entry.next = new Entry<>(key, value);
                    size++;
                    return;
                }

                entry = entry.next;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCapacity];

        for (int i = 0; i < table.length; i++) {
            Entry<K, V> curr = table[i];
            while (curr != null) {
                int newIndex = (curr.key.hashCode() & 0x7fffffff) % newCapacity;
                Entry<K, V> nextCurr = curr.next;
                curr.next = newTable[newIndex];
                newTable[newIndex] = curr;
                curr = nextCurr;
            }
        }
        table = newTable;
    }

    public V getOrDefault(K key, V defaultValue) {
        int index = hash(key);
        Entry<K, V> curr = table[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next; // if there's a collision we must go to next element
        }
        return defaultValue;
    }

    public boolean contains(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        int index = hash(key);
        Entry<K, V> curr = table[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void clear(){
        table = null;
        size = 0;
    }

    public void getSize(){
        System.out.println("Size of HashTable: " + size);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { return false; }
        HashTable<?, ?> hashTable = (HashTable<?, ?>) o;
        return true;
    }

    public int hash(K key){
        return Math.abs(key.hashCode() % table.length);
        // return 1;
    }

    public K getKey(K key) {
        return key;
    }

    public V getValue(V value) {
        return value;
    }
}