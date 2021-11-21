package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;
import by.lozovenko.informationhandler.testdata.TestSentenceProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeHandlerTest {
    TextComposite sentence;
    AbstractHandler handler;

    @BeforeMethod
    public void setUp() {
        sentence = new TextComposite(TextComponentType.SENTENCE);
        handler = new LexemeHandler();
    }

    @Test
    public void testHandleRequest() {
        TextComponent expectedSentence = TestSentenceProvider.createTestScienceSentence();

        handler.handleRequest(sentence, TestSentenceProvider.TEST_SCIENCE_SENTENCE);

        assertEquals(sentence, expectedSentence);
    }
}