package com.example.modules.fileModules.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class TextLinesNumberFileModule extends AbstractTextFileModule {

    @Override
    public String getDescription() {
        return "Подсчет количества строк в файле";
    }

    @Override
    public String getResult(File file, String arg) throws IOException {
        String result;
        if (file.exists()) {
            result = String.valueOf(Files.lines(file.toPath()).count());
        } else {
            throw new FileNotFoundException(file.getAbsolutePath());
        }

        return result;
    }
}
