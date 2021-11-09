package com.example.modules.fileModules.text;

import com.example.modules.exceptions.FileModuleException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class TextLinesNumberFileModule extends AbstractTextFileModule {

    @Override
    public String getDescription() {
        return "Подсчет количества строк в файле";
    }

    @Override
    public String getResult(File file, String arg) throws FileModuleException {
        String result;

        try {
            result = String.valueOf(Files.lines(file.toPath()).count());
        } catch (IOException e) {
            throw new FileModuleException(e);
        }

        return result;
    }
}
