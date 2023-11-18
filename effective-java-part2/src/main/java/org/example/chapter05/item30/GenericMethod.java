package org.example.chapter05.item30;

import java.util.*;

public class GenericMethod {

    public static void main(String[] args) {
        Set guys = new HashSet();
        guys.add("톰");
        guys.add("딕");
        guys.add("해리");
        Set stooges = new HashSet();
        stooges.add(1);
        stooges.add(2);
        stooges.add(3);
        Set all = union(guys, stooges);

        for (Object o : all) {
            System.out.println(o);
        }

        /*Set<String> guys = new HashSet<>();
        guys.add("톰");
        guys.add("딕");
        guys.add("해리");
        Set<String> stooges = new HashSet<>();
        stooges.add("1");
        stooges.add("2");
        stooges.add("3");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);*/
    }

    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /*public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }*/
}
