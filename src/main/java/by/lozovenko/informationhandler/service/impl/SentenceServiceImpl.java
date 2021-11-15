package by.lozovenko.informationhandler.service.impl;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;
import by.lozovenko.informationhandler.service.SentenceService;

import java.util.List;

public class SentenceServiceImpl implements SentenceService {
    private static SentenceServiceImpl INSTANCE;
    private SentenceServiceImpl(){
    }
    public static SentenceServiceImpl getInstance() {
        if (INSTANCE == null){
            INSTANCE = new SentenceServiceImpl();
        }
    return INSTANCE;
    }

    @Override
    public int countVowelLetter(TextComponent sentence) {
        return 0;
    }

    @Override
    public int countConsonantLetter(TextComponent sentence) {
        return 0;
    }

    @Override
    public int findLongestWordLength(TextComponent sentence){
        List<TextComponent> lexemes = sentence.getChildren();
        int currentLength;
        int maxLength = 0;
        for (TextComponent lexeme: lexemes) {
            List<TextComponent> lexemeComponents = lexeme.getChildren();
            for (TextComponent lexemeComponent: lexemeComponents) {
                if (lexemeComponent.getComponentType() == TextComponentType.WORD){
                    currentLength = lexemeComponent.getChildren().size();
                    if (maxLength < currentLength){
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
        for (TextComponent component: components) {
            TextComponentType componentType = component.getComponentType();
            if (componentType == TextComponentType.WORD){
                result++;
            }else if (componentType != TextComponentType.SYMBOL){
                result+=findWordsCount(component);
            }
        }
        return result;
    }
}
