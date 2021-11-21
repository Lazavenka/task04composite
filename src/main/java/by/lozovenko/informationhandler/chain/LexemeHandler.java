package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;

public class LexemeHandler extends AbstractHandler {
    private static final String LEXEME_DELIMITER = "\s+";
    private final AbstractHandler successor = new WordHandler();

    @Override
    public void handleRequest(TextComposite composite, String text) {
        String[] lexemes = text.split(LEXEME_DELIMITER);
        for (String lexemeString : lexemes) {
            TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);
            composite.add(lexeme);
            successor.handleRequest(lexeme, lexemeString);
        }
    }
}
