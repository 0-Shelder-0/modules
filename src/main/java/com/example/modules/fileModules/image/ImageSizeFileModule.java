package com.example.modules.fileModules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.png.PngDirectory;
import com.example.modules.exceptions.FileModuleException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import static com.example.modules.extensions.TagExtensions.getFormattedTagString;

@Component
public class ImageSizeFileModule extends AbstractImageFileModule {

    @Override
    public String getDescription() {
        return "Вывод размера изображения";
    }

    @Override
    public String getResult(File file, String arg) throws FileModuleException {
        String result;

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            StringBuilder fileDataStr = new StringBuilder();

            fileDataStr.append("Size:\n");
            metadata.getDirectoriesOfType(PngDirectory.class)
                    .stream()
                    .flatMap(p -> p.getTags().stream())
                    .filter(p -> p.getTagType() < 3)
                    .forEach(p -> fileDataStr.append(getFormattedTagString(p)));

            result = fileDataStr.toString();
        } catch (ImageProcessingException | IOException e) {
            throw new FileModuleException(e);
        }

        return result;
    }
}
