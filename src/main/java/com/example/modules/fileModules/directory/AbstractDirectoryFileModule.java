package com.example.modules.fileModules.directory;

import com.example.modules.fileModules.FileModule;

import java.io.File;

public abstract class AbstractDirectoryFileModule implements FileModule {

    @Override
    public boolean supportExtension(File file) {
        return file.isDirectory();
    }

    @Override
    public String getTypeDescription() {
        return "Каталог";
    }
}
