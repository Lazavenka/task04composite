package by.lozovenko.informationhandler.testdata;

import by.lozovenko.informationhandler.composite.*;

public class TestLexemeProvider {
    public static final String TEST_SCIENCE_LEXEME = "Science!";
    public static final String TEST_OB_RUN_LEXEME = "ob.run()";
    public static final String TEST_RIGA_LEXEME = "(Рига)";
    public static final String TEST_JAVA_LEXEME = "JAVA";

    public static TextComponent createExpectedScienceLexeme() {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        TextComponent word = new TextComposite(TextComponentType.WORD);
        word.add(new LeafSymbol('S', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('c', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('i', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('e', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('n', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('c', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('e', TextComponentType.SYMBOL, SymbolType.LETTER));
        lexeme.add(word);
        lexeme.add(new LeafSymbol('!', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));

        return lexeme;
    }

    public static TextComponent createExpectedObRunLexeme() {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        TextComponent word1 = new TextComposite(TextComponentType.WORD);
        TextComponent word2 = new TextComposite(TextComponentType.WORD);
        word1.add(new LeafSymbol('o', TextComponentType.SYMBOL, SymbolType.LETTER));
        word1.add(new LeafSymbol('b', TextComponentType.SYMBOL, SymbolType.LETTER));
        word2.add(new LeafSymbol('r', TextComponentType.SYMBOL, SymbolType.LETTER));
        word2.add(new LeafSymbol('u', TextComponentType.SYMBOL, SymbolType.LETTER));
        word2.add(new LeafSymbol('n', TextComponentType.SYMBOL, SymbolType.LETTER));

        lexeme.add(word1);
        lexeme.add(new LeafSymbol('.', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));
        lexeme.add(word2);
        lexeme.add(new LeafSymbol('(', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));
        lexeme.add(new LeafSymbol(')', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));
        return lexeme;
    }

    public static TextComponent createExpectedJavaLexeme() {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        TextComponent word = new TextComposite(TextComponentType.WORD);

        word.add(new LeafSymbol('J', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('A', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('V', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('A', TextComponentType.SYMBOL, SymbolType.LETTER));

        lexeme.add(word);

        return lexeme;
    }

    public static TextComponent createExpectedRigaLexeme() {
        TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
        TextComponent word = new TextComposite(TextComponentType.WORD);


        word.add(new LeafSymbol('Р', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('и', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('г', TextComponentType.SYMBOL, SymbolType.LETTER));
        word.add(new LeafSymbol('а', TextComponentType.SYMBOL, SymbolType.LETTER));

        lexeme.add(new LeafSymbol('(', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));
        lexeme.add(word);
        lexeme.add(new LeafSymbol(')', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));
        return lexeme;
    }
}
