package com.example.modules.fileModules.directory;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class DirectoryFileListFileModule extends AbstractDirectoryFileModule {

    @Override
    public String getDescription() {
        return "Вывод списка файлов в каталоге";
    }

    @Override
    public String getResult(File file, String arg) {
        return Arrays.stream(Objects.requireNonNull(file.listFiles(File::isFile)))
                     .map(File::getName)
                     .collect(Collectors.joining ("\n"));
    }
}
