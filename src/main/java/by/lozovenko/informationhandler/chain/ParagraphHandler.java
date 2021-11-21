package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;

public class ParagraphHandler extends AbstractHandler {
    private static final String PARAGRAPH_DELIMITER = "    ";
    private final AbstractHandler successor = new SentenceHandler();

    @Override
    public void handleRequest(TextComposite composite, String text) {
        String[] paragraphs = text.trim().split(PARAGRAPH_DELIMITER);
        for (String paragraphString : paragraphs) {
            TextComposite paragraph = new TextComposite(TextComponentType.PARAGRAPH);
            composite.add(paragraph);
            successor.handleRequest(paragraph, paragraphString);
        }
    }
}
