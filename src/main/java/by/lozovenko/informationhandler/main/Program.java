package by.lozovenko.informationhandler.main;

import by.lozovenko.informationhandler.chain.ParagraphHandler;
import by.lozovenko.informationhandler.composite.*;
import by.lozovenko.informationhandler.exception.ProjectException;
import by.lozovenko.informationhandler.reader.CustomFileReader;
import by.lozovenko.informationhandler.reader.impl.CustomFileReaderImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        text.add(new LeafSymbol('\t', TextComponentType.SYMBOL, SymbolType.PUNCTUATION));
        ParagraphHandler handler = new ParagraphHandler();
        handler.handleRequest(text, content);

        LOGGER.log(Level.INFO, text.compose());
    }
}
