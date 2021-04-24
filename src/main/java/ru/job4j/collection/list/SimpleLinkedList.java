package ru.job4j.collection.list;

import ru.job4j.generics.SimpleArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;

    @Override
    public void add(E value) {
        Node<E> tmp = last;
        Node<E> newNode = new Node<>(value, tmp, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        if (first == null) {
            return null;
        }
        int i = 0;
        Node<E> current = first;
        while (i != index) {
            current = current.next;
            i++;
        }
        return current.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(this);
    }

    public class SimpleLinkedListIterator<E> implements Iterator<E> {
        SimpleLinkedList<E> simpleLinkedList;
        Node<E> current;
        int count = 0;
        int expectedModCount = modCount;

        public SimpleLinkedListIterator(SimpleLinkedList<E> simpleLinkedList) {
            this.simpleLinkedList = simpleLinkedList;
        }

        @Override
        public boolean hasNext() {
            return count < simpleLinkedList.size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (count == 0) {
                current = simpleLinkedList.first;
            } else {
                current = current.next;
            }
            count++;
            return current.value;
        }
    }
}
