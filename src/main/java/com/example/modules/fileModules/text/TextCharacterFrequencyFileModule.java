package com.example.modules.fileModules.text;

import com.example.modules.exceptions.FileModuleException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class TextCharacterFrequencyFileModule extends AbstractTextFileModule {

    @Override
    public String getDescription() {
        return "Вывод частоты вхождения каждого символа";
    }

    @Override
    public String getResult(File file, String arg) throws FileModuleException {
        String result;

        if (arg == null || arg.length() != 1) {
            throw new FileModuleException("Символ не введен");
        }
        char searchSymbol = arg.toCharArray()[0];

        try {
            long counter = 0;
            for (String line : Files.readAllLines(file.toPath())) {
                for (char c : line.toCharArray()) {
                    if (c == searchSymbol) {
                        counter++;
                    }
                }
            }

            result = String.valueOf(counter);
        } catch (IOException e) {
            throw new FileModuleException(e);
        }

        return result;
    }
}
