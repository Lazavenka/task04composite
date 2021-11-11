package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends AbstractHandler{
    private static final String WORD_PUNCT_PATTERN = "(\\P{Punct}+)?(\\p{Punct}*)";
    private AbstractHandler successor = new SymbolHandler();
    @Override
    public void handleRequest(TextComposite composite, String text) {
        Pattern pattern = Pattern.compile(WORD_PUNCT_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String wordString = matcher.group(1);
            String punctuation = matcher.group(2);
            if(wordString != null) {
                TextComposite word = new TextComposite(TextComponentType.WORD);
                composite.add(word);
                successor.handleRequest(word, wordString);
            }
            if (!punctuation.isEmpty()){
                char[] punctuationSymbols = punctuation.toCharArray();
                for (char punctuationSymbol: punctuationSymbols) {
                    LeafSymbol symbol = new LeafSymbol(punctuationSymbol, TextComponentType.SYMBOL, SymbolType.PUNCTUATION);
                    composite.add(symbol);
                }
            }
        }
    }
}
