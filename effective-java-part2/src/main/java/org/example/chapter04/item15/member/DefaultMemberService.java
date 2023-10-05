package org.example.chapter04.item15.member;

class DefaultMemberService implements MemberService{ // MemberService의 구현체이기 때문에 내부 패키지 안에서만 존재해도 됨

    // DefaultMemberService에서만 MemberRepository 인터페이스를 사용한다면 private static으로 중첩
    // inner class지만 독립적
    // 왜 static을 붙일까
    // PrivateStaticClass을 감싸고 있는 DefaultMemberService에서만 접근 가능 (단방향)
    // 외부 클래스였던 것이 독립적인 내부클래스로 변경됨.
    private static class PrivateStaticClass {

    }

    // 외부 인스턴스 참조 가능
    private class PrivateClass {
    }
}
