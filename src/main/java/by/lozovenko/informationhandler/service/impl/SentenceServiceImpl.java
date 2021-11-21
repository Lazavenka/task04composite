package by.lozovenko.informationhandler.service.impl;

import by.lozovenko.informationhandler.composite.*;
import by.lozovenko.informationhandler.service.SentenceService;

import java.util.List;

public class SentenceServiceImpl implements SentenceService {

    private static SentenceServiceImpl INSTANCE;

    private static final String VOWEL_LETTERS = "[aeiouyAEIOYаеёиоуыэюяАЕЁИОУЫЭЮЯ]";

    private SentenceServiceImpl() {
    }

    public static SentenceServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SentenceServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public long countVowelLetter(TextComponent sentence) {
        long vowelLetters = 0;
        List<TextComponent> components = sentence.getChildren();
        for (TextComponent component : components) {
            TextComponentType componentType = component.getComponentType();
            if (componentType == TextComponentType.WORD) {
                long vowelInWord = component.getChildren().stream().map(TextComponent::compose).filter(s -> s.matches(VOWEL_LETTERS)).count();
                vowelLetters += vowelInWord;
            } else if (componentType != TextComponentType.SYMBOL) {
                vowelLetters += countVowelLetter(component);
            }
        }
        return vowelLetters;
    }

    @Override
    public long countConsonantLetter(TextComponent sentence) {
        long consonantLetters = 0;
        List<TextComponent> components = sentence.getChildren();
        for (TextComponent component : components) {
            TextComponentType componentType = component.getComponentType();
            if (componentType == TextComponentType.WORD) {
                long consonantInWord = component.getChildren().stream().map(TextComponent::compose).filter(s -> !s.matches(VOWEL_LETTERS)).count();
                consonantLetters += consonantInWord;
            } else if (componentType != TextComponentType.SYMBOL) {
                consonantLetters += countConsonantLetter(component);
            }
        }
        return consonantLetters;
    }

    @Override
    public int findLongestWordLength(TextComponent sentence) {
        List<TextComponent> lexemes = sentence.getChildren();
        int currentLength;
        int maxLength = 0;
        for (TextComponent lexeme : lexemes) {
            List<TextComponent> lexemeComponents = lexeme.getChildren();
            for (TextComponent lexemeComponent : lexemeComponents) {
                if (lexemeComponent.getComponentType() == TextComponentType.WORD) {
                    currentLength = lexemeComponent.getChildren().size();
                    if (maxLength < currentLength) {
                        maxLength = currentLength;
                    }
                }
            }
        }
        return maxLength;
    }

    @Override
    public int findWordsCount(TextComponent sentence) {
        int result = 0;
        List<TextComponent> components = sentence.getChildren();
        for (TextComponent component : components) {
            TextComponentType componentType = component.getComponentType();
            if (componentType == TextComponentType.WORD) {
                result++;
            } else if (componentType != TextComponentType.SYMBOL) {
                result += findWordsCount(component);
            }
        }
        return result;
    }
}
