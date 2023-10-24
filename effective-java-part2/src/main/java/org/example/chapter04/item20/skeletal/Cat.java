package org.example.chapter04.item20.skeletal;

public class Cat extends AbstractMammalia implements Animal {

    private String sound;
    private String name;

    @Override
    protected String kinds() {
        return "Cat";
    }
}
