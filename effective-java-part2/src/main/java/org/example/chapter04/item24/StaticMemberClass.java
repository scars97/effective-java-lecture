package org.example.chapter04.item24;

public class StaticMemberClass {

    private String email;

    public void exEmail() {
        ExStaticClass ex = new ExStaticClass();
        String name = ex.name;
    }

    static class ExStaticClass {
        String name;
    }
}
