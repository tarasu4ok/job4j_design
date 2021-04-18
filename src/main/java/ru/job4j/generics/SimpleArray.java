package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int count;

    public SimpleArray(int size) {
        this.data = (T[]) new Object[size];
    }

    public void add(T model) {
        data[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, data.length);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, data.length);
        System.arraycopy(data, index + 1, data, index, count - index);
    }

    public T get(int index) {
        Objects.checkIndex(index, data.length);
        return data[index];
    }

    public int getLength() {
         return data.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<T>(this);
    }

    public class SimpleArrayIterator<T> implements Iterator<T> {
        SimpleArray array;
        int count = 0;

        public SimpleArrayIterator(SimpleArray<T> array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return count < array.getLength();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) array.get(count++);
        }
    }
}
