package me.whiteship.chapter01.item01;

public interface HelloService {
    String hello();

    // 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    // 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    // 자바 8 이후로 인터페이스에 static 선언 가능
    static HelloService of(String lang) {
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }
}
