package org.example.chapter05.item32;

import java.util.ArrayList;
import java.util.List;

public class Dangerous {

    @SafeVarargs
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = new ArrayList<>();
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);
    }

    public static void main(String[] args) {
        dangerous();
    }
}
