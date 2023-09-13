package me.whiteship.chapter01.item08.autoclosable;

public class App {

    //언제 사용하는 지?
    //사용하지 않을 수도 있지만
    //try-with-resource를 사용하지 않더라도
    //AutoCloseable을 구현해놓고
    //자원이 반납될 수 있는 기회를 가질 수 있도록 = 안전망
    public static void main(String[] args) {
        try (AutoClosableIsGood good = new AutoClosableIsGood()) {
            // TODO 자원 반납 처리가 됨.
        }
    }
}
