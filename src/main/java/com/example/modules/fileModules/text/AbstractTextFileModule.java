package com.example.modules.fileModules.text;

import com.example.modules.fileModules.FileModule;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

public abstract class AbstractTextFileModule implements FileModule {
    private final List<String> _extensions = List.of("txt", "ini", "xml", "html");

    @Override
    public boolean supportExtension(File file) {
        String extension = FilenameUtils.getExtension(file.getName());
        return file.isFile() && _extensions.contains(extension);
    }
}
