package com.example.modules.fileModules;

import com.example.modules.exceptions.FileModuleException;

import java.io.File;

public interface FileModule {
    boolean supportExtension(File file);

    String getTypeDescription();

    String getDescription();

    String getResult(File file, String arg) throws FileModuleException;
}
