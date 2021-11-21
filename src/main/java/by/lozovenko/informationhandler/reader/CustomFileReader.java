package by.lozovenko.informationhandler.reader;

import by.lozovenko.informationhandler.exception.ProjectException;

public interface CustomFileReader {
    String readContentFromFile(String stringFilePath) throws ProjectException;
}
