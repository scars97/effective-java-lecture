package me.whiteship.chapter01.item05;

import java.util.List;

public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
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
