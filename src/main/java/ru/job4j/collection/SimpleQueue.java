package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn = 0;
    private int sizeOut = 0;

    public T poll() {
        if (sizeIn == 0 || sizeOut != 0) {
            return out.pop();
        }
        for (int i = 0; i < sizeIn; i++) {
            T el = in.pop();
            out.push(el);
        }
        sizeOut = sizeIn - 1;
        sizeIn = 0;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}
