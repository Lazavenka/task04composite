package by.lozovenko.informationhandler.service.impl;

import by.lozovenko.informationhandler.comparator.ParagraphNumberSentencesComparator;
import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;
import by.lozovenko.informationhandler.exception.ProjectException;
import by.lozovenko.informationhandler.service.SentenceService;
import by.lozovenko.informationhandler.service.TextService;

import java.util.*;


public class TextServiceImpl implements TextService {
    private static TextServiceImpl INSTANCE;

    private TextServiceImpl() {
    }

    public static TextServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TextServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public TextComposite sortParagraphBySentenceCount(TextComponent text) throws ProjectException {
        if (text.getComponentType() != TextComponentType.TEXT) {
            throw new ProjectException("Provided TextComponent is not a TEXT! Method is applied only for TEXT type.");
        }
        List<TextComponent> sortedParagraphs = text.getChildren()
                .stream().sorted(new ParagraphNumberSentencesComparator()).toList();
        TextComposite sortedText = new TextComposite(TextComponentType.TEXT);
        sortedParagraphs.forEach(sortedText::add);
        return sortedText;
    }

    @Override
    public List<TextComponent> findSentencesWithLongestWord(TextComponent text) {
        Map<TextComponent, Integer> sentencesWithLongestWordLength = new HashMap<>();
        int maxWordLength = 0;
        int currentSentenceMaxWordLength;
        SentenceService sentenceService = SentenceServiceImpl.getInstance();
        List<TextComponent> paragraphs = text.getChildren();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildren();
            for (TextComponent sentence : sentences) {
                currentSentenceMaxWordLength = sentenceService.findLongestWordLength(sentence);
                if (maxWordLength < currentSentenceMaxWordLength) {
                    maxWordLength = currentSentenceMaxWordLength;
                }
                sentencesWithLongestWordLength.put(sentence, currentSentenceMaxWordLength);
            }
        }
        final int finalMaxWordLength = maxWordLength;
        sentencesWithLongestWordLength.entrySet().removeIf(e -> e.getValue() < finalMaxWordLength);
        return sentencesWithLongestWordLength.keySet().stream().toList();
    }

    @Override
    public Map<TextComponent, Integer> countSameWordsIgnoreCase(TextComponent text) {
        Map<TextComponent, Integer> wordsMap = new HashMap<>();
        List<TextComponent> components = text.getChildren();
        for (TextComponent component : components) {
            TextComponentType type = component.getComponentType();
            if (type == TextComponentType.WORD) {
                putWordInMap(component, 1, wordsMap);
            } else if (type != TextComponentType.SYMBOL) {
                Map<TextComponent, Integer> partWordsMap = countSameWordsIgnoreCase(component);
                mergeAll(wordsMap, partWordsMap);
            }
        }
        if (text.getComponentType() == TextComponentType.TEXT) {
            wordsMap.entrySet().removeIf(e -> e.getValue() == 1);
        }
        return wordsMap;
    }

    private void mergeAll(Map<TextComponent, Integer> currentMap, Map<TextComponent, Integer> newMap) {
        for (Map.Entry<TextComponent, Integer> entryWord : newMap.entrySet()) {
            putWordInMap(entryWord, currentMap);
        }
    }

    private void putWordInMap(Map.Entry<TextComponent, Integer> wordEntry, Map<TextComponent, Integer> wordsMap) {
        TextComponent word = wordEntry.getKey();
        Integer count = wordEntry.getValue();
        putWordInMap(word, count, wordsMap);
    }

    private void putWordInMap(TextComponent word, Integer count, Map<TextComponent, Integer> wordsMap) {
        Map.Entry<TextComponent, Boolean> wordIfPresent = getExistingWordComponent(word, wordsMap);
        TextComponent existingWord = wordIfPresent.getKey();
        boolean exist = wordIfPresent.getValue();
        if (exist) {
            int newCount = wordsMap.get(existingWord) + count;
            wordsMap.put(existingWord, newCount);
        } else {
            wordsMap.put(existingWord, count);
        }
    }

    private Map.Entry<TextComponent, Boolean> getExistingWordComponent(TextComponent word, Map<TextComponent, Integer> wordsMap) {
        String stringWord = word.compose();
        Map.Entry<TextComponent, Boolean> result = new AbstractMap.SimpleImmutableEntry<>(word, false);
        for (Map.Entry<TextComponent, Integer> entry : wordsMap.entrySet()) {
            TextComponent currentWord = entry.getKey();
            if (currentWord.compose().equalsIgnoreCase(stringWord)) {
                result = new AbstractMap.SimpleImmutableEntry<>(currentWord, true);
            }
        }
        return result;
    }

    @Override
    public void removeSentencesIfWordsLess(int wordsNumber, TextComponent text) {
        int wordsCount;
        SentenceService sentenceService = SentenceServiceImpl.getInstance();
        List<TextComponent> components = text.getChildren();
        for (TextComponent component : components) {
            TextComponentType componentType = component.getComponentType();
            if (componentType == TextComponentType.SENTENCE) {
                wordsCount = sentenceService.findWordsCount(component);
                if (wordsCount < wordsNumber) {
                    text.remove(component);
                }
            } else {
                removeSentencesIfWordsLess(wordsNumber, component);
            }
        }
    }
}
