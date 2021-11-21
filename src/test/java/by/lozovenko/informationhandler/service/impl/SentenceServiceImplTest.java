package by.lozovenko.informationhandler.service.impl;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.service.SentenceService;
import by.lozovenko.informationhandler.testdata.TestSentenceProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceServiceImplTest {
    SentenceService sentenceService;
    TextComponent sentence;

    @BeforeClass
    public void setUp() {
        sentence = TestSentenceProvider.createTestScienceSentence();
        sentenceService = SentenceServiceImpl.getInstance();
    }

    @Test
    public void testCountVowelLetter() {
        final long expectedVowels = 9;

        final long actualVowels = sentenceService.countVowelLetter(sentence);

        assertEquals(actualVowels, expectedVowels);
    }

    @Test
    public void testCountConsonantLetter() {
        final long expectedConsonants = 11;

        final long actualConsonants = sentenceService.countConsonantLetter(sentence);

        assertEquals(actualConsonants, expectedConsonants);
    }

    @Test
    public void testFindLongestWordLength() {
        final int expectedLongestWordLength = 7;

        final int actualLongestWordLength = sentenceService.findLongestWordLength(sentence);

        assertEquals(actualLongestWordLength, expectedLongestWordLength);
    }

    @Test
    public void testFindWordsCount() {
        final int expectedWordsCount = 5;

        final int actualWordsCount = sentenceService.findWordsCount(sentence);

        assertEquals(actualWordsCount, expectedWordsCount);
    }
}