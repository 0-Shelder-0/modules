package com.example.modules.fileModules.audio;

import com.example.modules.fileModules.FileModule;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

public abstract class AbstractAudioFileModule implements FileModule {
    private final List<String> _extensions =
        List.of("mp3", "wma", "aac", "m4a", "m4p", "m4b", "mp4", "3gp", "ogg", "oga", "sb0", "ogv");

    @Override
    public boolean supportExtension(File file) {
        String extension = FilenameUtils.getExtension(file.getName());
        return file.isFile() && _extensions.contains(extension);
    }

    @Override
    public String getTypeDescription() {
        return "Аудио файл";
    }
}
