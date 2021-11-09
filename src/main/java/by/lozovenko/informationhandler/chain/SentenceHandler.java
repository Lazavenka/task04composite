package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends AbstractHandler{
    private AbstractHandler successor = new LexemeHandler();
    private static final String SENTENCE_PATTERN = "(.*?[!?.]\s)(.*[!?.])*";
    @Override
    public void handleRequest(TextComposite composite, String text) {
        Pattern sentencePattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = sentencePattern.matcher(text);
        while (matcher.find()){
            String sentenceString = matcher.group();
            TextComposite sentence = new TextComposite(TextComponentType.SENTENCE);
            composite.add(sentence);
            successor.handleRequest(sentence, sentenceString);
        }
    }
}
