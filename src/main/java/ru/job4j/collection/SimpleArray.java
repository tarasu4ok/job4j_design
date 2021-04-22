package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int count = 0;
    int modCount = 0;

    public SimpleArray() {
        this.container = new Object[5];
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        if (count == container.length) {
            resize();
        }
        container[count++] = model;
        modCount++;
    }

    private void resize() {
        Object[] newContainer = new Object[count * 2];
        System.arraycopy(container, 0, newContainer, 0, count);
        container = newContainer;
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<T>(this);
    }

    public class SimpleArrayIterator<T> implements Iterator<T> {
        SimpleArray array;
        int count = 0;
        int expectedModCount = modCount;

        public SimpleArrayIterator(SimpleArray<T> array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return count < array.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) array.get(count++);
        }
    }
}
