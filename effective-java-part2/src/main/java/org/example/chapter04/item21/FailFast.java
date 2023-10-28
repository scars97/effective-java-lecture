package org.example.chapter04.item21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // 이터레이터로 콜렉션을 순회하는 중에 Collection의 remove를 사용할 경우
        // ConcurrentModificationException 발생
//        for (Integer number : numbers) {
//            if (number == 3) {
//                numbers.remove(number);
//            }
//        }


        // 이터레이터를 직접 사용해서 remove를 사용할 경우 정상 실행
//        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
//            Integer integer = iterator.next();
//            if (integer == 3) {
//                iterator.remove();
//            }
//        }
//
//        // 인덱스 사용
//        // 정상 실행
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                numbers.remove(numbers.get(i));
            }
        }
//
//        // removeIf 사용하기
//        // 이터레이터를 직접 사용한 것과 같음
        numbers.removeIf(number -> number == 3);
        numbers.forEach(System.out::println);
    }
}
