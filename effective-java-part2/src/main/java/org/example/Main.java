package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> stringList = new ArrayList<>();
        stringList.add(4);
        test(stringList);
    }

    public static void test(List<?> lists) {
        String genericString = lists.getClass().toGenericString();
        System.out.println("genericString = " + genericString);
        System.out.println(lists.get(0));
    }
}