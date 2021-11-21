package by.lozovenko.informationhandler.composite;

import by.lozovenko.informationhandler.testdata.TestParagraphProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextCompositeTest {
    TextComposite testText;

    @BeforeClass
    public void setUp() {
        testText = new TextComposite(TextComponentType.TEXT);
        TextComponent testParagraph = TestParagraphProvider.createExpectedParagraph();
        testText.add(testParagraph);
    }

    @Test
    public void testCompose() {
        String expectedString = TestParagraphProvider.TEST_PARAGRAPH;

        String actualString = testText.compose();

        assertEquals(actualString, expectedString);
    }
}