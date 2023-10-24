package org.example.chapter04.item20.templatemethod;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("src/main/java/org/example/chapter04/item20/templatemethod/number.txt");
        System.out.println(fileProcessor.process());
    }
}
