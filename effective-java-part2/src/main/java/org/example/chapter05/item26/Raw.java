package org.example.chapter05.item26;

import java.util.ArrayList;
import java.util.List;

public class Raw {
    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        unsafeAdd(strings, Integer.valueOf(42));
//        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.
    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }
}
