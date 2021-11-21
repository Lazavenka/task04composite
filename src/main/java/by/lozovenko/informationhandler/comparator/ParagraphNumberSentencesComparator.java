package by.lozovenko.informationhandler.comparator;

import by.lozovenko.informationhandler.composite.TextComponent;

import java.util.Comparator;

public class ParagraphNumberSentencesComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int sentencesCountOne = o1.getChildren().size();
        int sentencesCountTwo = o2.getChildren().size();
        return sentencesCountOne - sentencesCountTwo;
    }
}
