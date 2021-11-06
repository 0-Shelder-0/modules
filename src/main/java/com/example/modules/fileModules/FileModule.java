package com.example.modules.fileModules;

import java.io.File;
import java.io.IOException;

public interface FileModule {
    boolean supportExtension(File file);

    String getDescription();

    String getResult(File file, String arg) throws IOException;
}
