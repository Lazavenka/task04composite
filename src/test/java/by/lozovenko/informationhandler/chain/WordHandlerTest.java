package by.lozovenko.informationhandler.chain;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;
import by.lozovenko.informationhandler.testdata.TestLexemeProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordHandlerTest {
    TextComposite lexeme;
    AbstractHandler handler;
    @BeforeMethod
    public void setUp(){
        lexeme = new TextComposite(TextComponentType.LEXEME);
        handler = new WordHandler();
    }
    @Test
    public void testHandleRequestJavaWord() {
        TextComponent expectedJavaLexeme = TestLexemeProvider.createExpectedJavaLexeme();

        handler.handleRequest(lexeme, TestLexemeProvider.TEST_JAVA_LEXEME);

        assertEquals(lexeme, expectedJavaLexeme);
    }
    @Test
    public void testHandleRequestScienceWord() {
        TextComponent expectedJavaLexeme = TestLexemeProvider.createExpectedScienceLexeme();

        handler.handleRequest(lexeme, TestLexemeProvider.TEST_SCIENCE_LEXEME);

        assertEquals(lexeme, expectedJavaLexeme);
    }

    @Test
    public void testHandleRequestObRunWord() {
        TextComponent expectedJavaLexeme = TestLexemeProvider.createExpectedObRunLexeme();

        handler.handleRequest(lexeme, TestLexemeProvider.TEST_OB_RUN_LEXEME);

        assertEquals(lexeme, expectedJavaLexeme);
    }
}