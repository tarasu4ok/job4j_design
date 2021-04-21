package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {

    @Test
    public void add() {
        MemStore<Base> memStore = new MemStore<>();
        memStore.add(new User("fgRsC"));
        Base element = memStore.findById("fgRsC");
        assertThat("fgRsC", is(element.getId()));
    }

    @Test
    public void replaceWithSuccess() {
        MemStore<Base> memStore = new MemStore<>();
        memStore.add(new User("fgRsC"));
        assertTrue(memStore.replace("fgRsC", new Role("xpYgQ")));
        assertNull(memStore.findById("fgRsC"));
        assertThat("xpYgQ", is(memStore.findById("xpYgQ").getId()));
    }

    @Test
    public void replaceWithoutSuccess() {
        MemStore<Base> memStore = new MemStore<>();
        memStore.add(new User("fgRsC"));
        assertFalse(memStore.replace("fgRcC", new Role("xpYgQ")));
        assertThat("fgRsC", is(memStore.findById("fgRsC").getId()));
        assertNull(memStore.findById("xpYgQ"));
    }

    @Test
    public void deleteWithSuccess() {
        MemStore<Base> memStore = new MemStore<>();
        memStore.add(new User("fgRsC"));
        memStore.add(new Role("xgEuP"));
        assertTrue(memStore.delete("fgRsC"));
        assertNull(memStore.findById("fgRsC"));
    }

    @Test
    public void deleteWithoutSuccess() {
        MemStore<Base> memStore = new MemStore<>();
        memStore.add(new User("fgRsC"));
        memStore.add(new Role("xgEuP"));
        assertFalse(memStore.delete("fgRcC"));
        assertThat("fgRsC", is(memStore.findById("fgRsC").getId()));
    }

    @Test
    public void findById() {
        MemStore<Base> memStore = new MemStore<>();
        memStore.add(new User("fgRsC"));
        Base element = memStore.findById("fgRsC");
        assertThat("fgRsC", is(element.getId()));
    }
}