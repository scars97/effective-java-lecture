package org.example.chapter04.item21;

public class SubClass extends SuperClass implements MarkerInterface{

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        // 클래스가 인터페이스를 이기기 때문에 SuperClass의 hello()를 호출
        subClass.hello();
    }
}
