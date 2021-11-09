package com.example.modules.fileModules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.example.modules.exceptions.FileModuleException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import static com.example.modules.extensions.TagExtensions.getFormattedTagString;

@Component
public class ImageExifFileModule extends AbstractImageFileModule {

    @Override
    public String getDescription() {
        return "Вывод информации exif";
    }

    @Override
    public String getResult(File file, String arg) throws FileModuleException {
        String result;

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            StringBuilder fileDataStr = new StringBuilder();

            fileDataStr.append("EXIF information:\n");
            metadata.getDirectories()
                    .forEach(p -> p.getTags()
                                   .forEach(tag -> fileDataStr.append(getFormattedTagString(tag))));

            result = fileDataStr.toString();
        } catch (ImageProcessingException | IOException e) {
            throw new FileModuleException(e);
        }

        return result;
    }
}