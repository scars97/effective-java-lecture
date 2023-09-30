package me.whiteship.chapter01.item14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
    public static void main(String[] args) {
        String[] values = new String[]{"keesun", "whiteship", "java"};

        Set<String> s = new TreeSet<>();
        Collections.addAll(s, values);
        System.out.println(s);
    }
}
