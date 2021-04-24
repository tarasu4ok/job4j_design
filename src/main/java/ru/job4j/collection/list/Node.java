package ru.job4j.collection.list;

public class Node<E> {
    E value;
    Node<E> previous;
    Node<E> next;

    public Node(E value, Node<E> previous, Node<E> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}
