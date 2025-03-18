package org.example;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, String> ht = new HashTable<>();

        ht.put(1, "A");
        ht.put(2, "B");
        ht.put(3, "C");
        ht.printTable();
        ht.getSize();

        ht.put(4, "D");
        ht.put(5, "E");
        ht.put(6, "F");

        ht.printTable();

        String value1 = ht.getOrDefault(1, "B");
        System.out.println(value1);

        ht.getSize();

        System.out.println(ht.contains(1));
        ht.clear();
        ht.getSize();
        ht.printTable();
    }
}