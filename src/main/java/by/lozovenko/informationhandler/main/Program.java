package by.lozovenko.informationhandler.main;

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
    }
}
