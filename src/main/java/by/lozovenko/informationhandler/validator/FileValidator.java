package by.lozovenko.informationhandler.validator;

import java.io.File;

public class FileValidator {
    private static FileValidator INSTANCE;

    private FileValidator() {
    }

    public static FileValidator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileValidator();
        }
        return INSTANCE;
    }

    public boolean validate(String filepath) {
        File file = new File(filepath);
        return file.isFile() && file.canRead();
    }
}
