package ru.job4j.generics;

import org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenAdd1And2ThenGet1InIndex0() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        assertThat(1, is(simpleArray.get(0)));
    }

    @Test
    public void whenAdd1And2And3Remove2ThenGet1And3InIndex0And1() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.remove(1);
        assertThat(1, is(simpleArray.get(0)));
        assertThat(3, is(simpleArray.get(1)));
    }

    @Test
    public void whenAdd1And2And3Set1With5ThenCheckAllValues() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(0, 5);
        assertThat(5, is(simpleArray.get(0)));
        assertThat(2, is(simpleArray.get(1)));
        assertThat(3, is(simpleArray.get(2)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAdd1And2And3And4And5GetIndex5ThenIndexOutOfBoundsException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        System.out.println(simpleArray.get(5));
    }

    @Test
    public void whenAdd1And2And3AndCheckNextInIterator() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAdd1AndMake2TimesNextThenNoSuchElementException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertFalse(iterator.hasNext());
        iterator.next();
    }
}