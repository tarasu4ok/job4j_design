package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    private int findIndexById(String id) {
        for (int index = 0; index < mem.size(); index++) {
            if (id.equals(mem.get(index).getId())) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        if (index != -1) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            mem.remove(index);
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
