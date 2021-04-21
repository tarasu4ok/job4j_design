package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T object = findById(id);
        if (object != null) {
            mem.set(mem.indexOf(object), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        T object = findById(id);
        if (object != null) {
            mem.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (T el : mem) {
            if (id.equals(el.getId())) {
                return el;
            }
        }
        return (T) null;
    }
}
