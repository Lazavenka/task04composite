package by.lozovenko.informationhandler.service;

import by.lozovenko.informationhandler.composite.TextComponent;

public interface SentenceService {
    long countVowelLetter(TextComponent sentence);

    long countConsonantLetter(TextComponent sentence);

    int findLongestWordLength(TextComponent sentence);

    int findWordsCount(TextComponent sentence);
}
