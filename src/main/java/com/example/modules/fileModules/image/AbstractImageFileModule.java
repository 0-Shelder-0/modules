package com.example.modules.fileModules.image;

import com.example.modules.fileModules.FileModule;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

public abstract class AbstractImageFileModule implements FileModule {
    private final List<String> _extensions =
        List.of("jpg", "jpeg", "jpe", "tif", "tiff", "webp", "psd", "png", "bmp", "dib", "rle", "gif", "ico", "pcx", "pcc");

    @Override
    public boolean supportExtension(File file) {
        String extension = FilenameUtils.getExtension(file.getName());
        return file.isFile() && _extensions.contains(extension);
    }

    @Override
    public String getTypeDescription() {
        return "Изображение";
    }
}
