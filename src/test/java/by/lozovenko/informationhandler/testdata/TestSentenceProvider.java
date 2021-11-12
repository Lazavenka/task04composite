package by.lozovenko.informationhandler.testdata;

import by.lozovenko.informationhandler.composite.*;

public class TestSentenceProvider {
    public static final String TEST_SCIENCE_SENTENCE = "JAVA (Рига) ob.run() Science!";
    public static TextComponent createTestScienceSentence(){
        TextComponent sentence = new TextComposite(TextComponentType.SENTENCE);
        TextComponent javaLexeme = TestLexemeProvider.createExpectedJavaLexeme();
        TextComponent rigaLexeme = TestLexemeProvider.createExpectedRigaLexeme();
        TextComponent obRunLexeme = TestLexemeProvider.createExpectedObRunLexeme();
        TextComponent scienceLexeme = TestLexemeProvider.createExpectedScienceLexeme();
        sentence.add(javaLexeme);
        sentence.add(rigaLexeme);
        sentence.add(obRunLexeme);
        sentence.add(scienceLexeme);
        return sentence;
    }
}
