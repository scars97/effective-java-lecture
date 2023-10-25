package org.example.chapter04.item21;

public interface MarkerInterface {
    default void hello() {
        System.out.println("hello interface");
    }
}
