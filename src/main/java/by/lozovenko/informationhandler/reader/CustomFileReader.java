package by.lozovenko.informationhandler.reader;

import by.lozovenko.informationhandler.exception.ProjectException;

import java.util.List;

public interface CustomFileReader {
    String readContentFromFile(String stringFilePath) throws ProjectException;
}
