package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class DiSpellChecker {

    private final Dictionary dictionary;

    public DiSpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    // 자원을 만들어주는 함수형 인터페이스(Supplier)를 인자로 받음
    public DiSpellChecker(Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        // ...
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // ...
        return dictionary.closeWordsTo(typo);
    }
}
