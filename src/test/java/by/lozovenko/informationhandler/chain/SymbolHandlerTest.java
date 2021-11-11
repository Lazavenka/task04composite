package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;
import by.lozovenko.informationhandler.testdata.TestWordProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SymbolHandlerTest {
    TextComposite word;
    AbstractHandler handler;
    @BeforeClass
    public void setUp(){
        word = new TextComposite(TextComponentType.WORD);
        handler = new SymbolHandler();
    }

    @Test
    public void testHandleRequest() {
        TextComponent expectedWord = TestWordProvider.createExpectedWord();

        handler.handleRequest(word, TestWordProvider.TEST_SCIENCE_WORD);

        assertEquals(word, expectedWord);
    }
}