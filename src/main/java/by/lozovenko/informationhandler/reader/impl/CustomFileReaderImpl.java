package by.lozovenko.informationhandler.reader.impl;

import by.lozovenko.informationhandler.exception.ProjectException;
import by.lozovenko.informationhandler.reader.CustomFileReader;
import by.lozovenko.informationhandler.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String readContentFromFile(String filepath) throws ProjectException {
        FileValidator validator = FileValidator.getInstance();
        if (!validator.validate(filepath)){
            throw new ProjectException("Incorrect file: " + filepath);
        }
        String content = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            List<String> strings = reader.lines().toList();
            content = String.join("", strings);
        }catch (IOException e){
            LOGGER.log(Level.ERROR, "File is invalid. {}", e.getMessage());
        }
        return content;
    }
}
