package by.lozovenko.informationhandler.service;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComposite;

import java.util.List;
import java.util.Map;

public interface TextService {
    TextComposite sortParagraphBySentenceCount(TextComponent text);
    List<TextComponent> findSentencesWithLongestWord(TextComponent text);
    Map<TextComponent, Integer> countSameWordsIgnoreCase(TextComponent text);
    void removeSentencesIfWordsLess(int wordsNumber, TextComponent text);

}
