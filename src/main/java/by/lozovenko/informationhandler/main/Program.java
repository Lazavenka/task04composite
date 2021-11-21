package by.lozovenko.informationhandler.main;

import by.lozovenko.informationhandler.chain.ParagraphHandler;
import by.lozovenko.informationhandler.composite.*;
import by.lozovenko.informationhandler.exception.ProjectException;
import by.lozovenko.informationhandler.reader.CustomFileReader;
import by.lozovenko.informationhandler.reader.impl.CustomFileReaderImpl;
import by.lozovenko.informationhandler.service.TextService;
import by.lozovenko.informationhandler.service.impl.TextServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Program {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String FILEPATH = "data/text.txt";

    public static void main(String[] args) throws ProjectException {
        ClassLoader loader = Program.class.getClassLoader();
        String absolutePath = loader.getResource(FILEPATH).getPath();
        CustomFileReader reader = new CustomFileReaderImpl();
        String content = reader.readContentFromFile(absolutePath);

        LOGGER.log(Level.INFO, content);

        TextComposite text = new TextComposite(TextComponentType.TEXT);
        ParagraphHandler handler = new ParagraphHandler();
        handler.handleRequest(text, content);
        TextService textService = TextServiceImpl.getInstance();
        Map<TextComponent, Integer> wordsMap = textService.countSameWordsIgnoreCase(text);
        List<TextComponent> sentencesWithLongestWord = textService.findSentencesWithLongestWord(text);
        LOGGER.log(Level.INFO, sentencesWithLongestWord);
        LOGGER.log(Level.INFO, wordsMap);
        String textCompose = text.compose();
        LOGGER.log(Level.INFO, textCompose);
        TextComposite sortedText = textService.sortParagraphBySentenceCount(text);
        String sortedTextCompose = sortedText.compose();
        LOGGER.log(Level.INFO, sortedTextCompose);
    }
}
