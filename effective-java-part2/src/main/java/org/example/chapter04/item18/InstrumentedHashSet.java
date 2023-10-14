package org.example.chapter04.item18;

import java.util.*;

public class InstrumentedHashSet<E> extends HashSet<E>{

    //private HashSet<E> h;

    private int addCount = 0;

    public InstrumentedHashSet() {
        //this.h = new HashSet<>();
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    /*public boolean add(E e) {
        addCount++;
        return h.add(e);
    }*/

    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    /*public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return h.addAll(c);
    }*/

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("틱", "탁탁", "펑"));
        System.out.println(s.getAddCount());
    }
}
