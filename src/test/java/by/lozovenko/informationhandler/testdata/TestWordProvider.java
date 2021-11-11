package by.lozovenko.informationhandler.testdata;

import by.lozovenko.informationhandler.composite.*;

public class TestWordProvider {
    public static final String TEST_SCIENCE_WORD = "Science";
    public static TextComponent createExpectedWord(){
        TextComponent word = new TextComposite(TextComponentType.WORD);
        word.add(new LeafSymbol('S', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('c', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('i', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('e', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('n', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('c', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('e', TextComponentType.SYMBOL, SymbolType.LETTER));
        return word;
    }
}
