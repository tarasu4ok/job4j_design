package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (int index = 0; index < set.size(); index++) {
            if ((value == null && set.get(index) == null) || (value != null && value.equals(set.get(index)))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(null);
        set.add(1);
        for (Integer el:set) {
            System.out.println(el == null);
        }
    }
}
