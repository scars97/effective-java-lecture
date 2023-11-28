package org.example.chapter05.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {

    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void put(Class<T> type, T instance) {
        this.map.put(Objects.requireNonNull(type), instance);
    }

    public <T> T get(Class<T> type) {
        return type.cast(this.map.get(type));
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        //favorites.put(String.class, "seong");
        //favorites.put(Integer.class, 2);
        favorites.put((Class)String.class, 1);
        String s = favorites.get(String.class);
        //Integer integer = favorites.get(Integer.class);

        System.out.println("s = " + s);
        //System.out.println("integer = " + integer);
    }
}
