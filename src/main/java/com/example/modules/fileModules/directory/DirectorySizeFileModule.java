package com.example.modules.fileModules.directory;

import java.io.File;

public class DirectorySizeFileModule extends AbstractDirectoryFileModule {

    @Override
    public String getDescription() {
        return "Подсчет размера всех файлов в каталоге";
    }

    @Override
    public String getResult(File file, String arg) {
        return String.valueOf(file.getTotalSpace());
    }
}
