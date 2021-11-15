package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;
import by.lozovenko.informationhandler.testdata.TestParagraphProvider;
import by.lozovenko.informationhandler.testdata.TestSentenceProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceHandlerTest {
    TextComposite paragraph;
    AbstractHandler handler;
    @BeforeMethod
    public void setUp(){
        paragraph = new TextComposite(TextComponentType.PARAGRAPH);
        handler = new SentenceHandler();
    }
    @Test
    public void testHandleRequest() {
        TextComponent expectedParagraph = TestParagraphProvider.createExpectedParagraph();

        handler.handleRequest(paragraph, TestParagraphProvider.TEST_PARAGRAPH);

        assertEquals(paragraph, expectedParagraph);
    }
}