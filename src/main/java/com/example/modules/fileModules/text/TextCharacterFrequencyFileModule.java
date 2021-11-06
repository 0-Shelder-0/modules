package com.example.modules.fileModules.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class TextCharacterFrequencyFileModule extends AbstractTextFileModule {

    @Override
    public String getDescription() {
        return "Вывод частоты вхождения каждого символа";
    }

    @Override
    public String getResult(File file, String arg) throws IOException {
        String result;
        if (file.exists()) {
            result = String.valueOf(Files.lines(file.toPath()).filter(p -> p.contains(arg)).count());
        } else {
            throw new FileNotFoundException(file.getAbsolutePath());
        }

        return result;
    }
}
