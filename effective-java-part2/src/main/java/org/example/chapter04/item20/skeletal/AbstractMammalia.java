package org.example.chapter04.item20.skeletal;

public abstract class AbstractMammalia implements Animal {

    @Override
    public void classification() {
        System.out.println("Mammalia");
    }

    protected abstract String kinds();

}
