package com.example.modules.fileModules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

import java.io.File;
import java.io.IOException;

public class ImageSizeFileModule extends AbstractImageFileModule {

    @Override
    public String getDescription() {
        return "Вывод размера изображения";
    }

    @Override
    public String getResult(File file, String arg) throws IOException {
        String result;
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            result = metadata.toString();
        } catch (ImageProcessingException e) {
            throw new IOException(e.getCause());
        }
        return result;
    }
}
