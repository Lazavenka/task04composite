package by.lozovenko.informationhandler.main;

import by.lozovenko.informationhandler.composite.LeafSymbol;
import by.lozovenko.informationhandler.composite.SymbolType;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;

public class TesterComposite {
    public static void main(String[] args) {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        TextComposite paragraph1 = new TextComposite(TextComponentType.PARAGRAPH);
        TextComposite sentence1 = new TextComposite(TextComponentType.SENTENCE);
        TextComposite sentence2 = new TextComposite(TextComponentType.SENTENCE);
        TextComposite lexeme1s1 = new TextComposite(TextComponentType.LEXEME);
        TextComposite lexeme2s1 = new TextComposite(TextComponentType.LEXEME);
        TextComposite lexeme1s2 = new TextComposite(TextComponentType.LEXEME);
        TextComposite lexeme2s2 = new TextComposite(TextComponentType.LEXEME);
        TextComposite word1s1 = new TextComposite(TextComponentType.WORD);
        TextComposite word2s1 = new TextComposite(TextComponentType.WORD);
        TextComposite word1s2 = new TextComposite(TextComponentType.WORD);
        TextComposite word2s2 = new TextComposite(TextComponentType.WORD);
        text.add(paragraph1);
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);
        sentence1.add(lexeme1s1);
        sentence1.add(lexeme2s1);
        sentence2.add(lexeme1s2);
        sentence2.add(lexeme2s2);

        lexeme1s1.add(word1s1);
        lexeme1s2.add(word1s2);
        lexeme2s1.add(word2s1);
        lexeme2s2.add(word2s2);
        LeafSymbol j = new LeafSymbol('J', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol a = new LeafSymbol('a', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol v = new LeafSymbol('v', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol anotherA = new LeafSymbol('a', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol colon = new LeafSymbol(',', TextComponentType.SYMBOL, SymbolType.PUNCTUATION);
        word1s1.add(j);
        word1s1.add(a);
        word1s1.add(v);
        word1s1.add(anotherA);
        lexeme1s1.add(colon);
        LeafSymbol c = new LeafSymbol('c', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol o = new LeafSymbol('o', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol o2 = new LeafSymbol('o', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol l = new LeafSymbol('l', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol dot = new LeafSymbol('.', TextComponentType.SYMBOL, SymbolType.PUNCTUATION);
        word2s1.add(c);
        word2s1.add(o);
        word2s1.add(o2);
        word2s1.add(l);
        lexeme2s1.add(dot);

        LeafSymbol q = new LeafSymbol('Q', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol w = new LeafSymbol('u', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol e = new LeafSymbol('s', TextComponentType.SYMBOL, SymbolType.LETTER);

        word1s2.add(q);
        word1s2.add(w);
        word1s2.add(e);

        LeafSymbol i = new LeafSymbol('a', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol p = new LeafSymbol('s', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol b = new LeafSymbol('k', TextComponentType.SYMBOL, SymbolType.LETTER);
        LeafSymbol b1 = new LeafSymbol('!', TextComponentType.SYMBOL, SymbolType.PUNCTUATION);

        word2s2.add(i);
        word2s2.add(p);
        word2s2.add(b);
        lexeme2s2.add(b1);

        String textString = text.compose();
        System.out.println(textString);
    }
}
