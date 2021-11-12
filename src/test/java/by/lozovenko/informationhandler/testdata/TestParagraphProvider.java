package by.lozovenko.informationhandler.testdata;

import by.lozovenko.informationhandler.composite.TextComponent;
import by.lozovenko.informationhandler.composite.TextComponentType;
import by.lozovenko.informationhandler.composite.TextComposite;

public class TestParagraphProvider {
    public static final String TEST_PARAGRAPH = "JAVA (Рига) ob.run() Science! JAVA (Рига) ob.run() Science! JAVA (Рига) ob.run() Science!";

    public static TextComponent createExpectedParagraph(){
        TextComponent paragraph = new TextComposite(TextComponentType.PARAGRAPH);
        TextComponent sentence1 = TestSentenceProvider.createTestScienceSentence();
        TextComponent sentence2 = TestSentenceProvider.createTestScienceSentence();
        TextComponent sentence3 = TestSentenceProvider.createTestScienceSentence();

        paragraph.add(sentence1);
        paragraph.add(sentence2);
        paragraph.add(sentence3);

        return paragraph;
    }
}
