package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.DefaultDictionary;

class DiSpellCheckerTest {

    public static void main(String[] args) {
        //DiSpellChecker spellChecker = new DiSpellChecker(() -> new DefaultDictionary());
        //DiSpellChecker spellChecker = new DiSpellChecker(DefaultDictionary::new);
        DiSpellChecker spellChecker = new DiSpellChecker(() -> DictionaryFactory.get());
    }
}