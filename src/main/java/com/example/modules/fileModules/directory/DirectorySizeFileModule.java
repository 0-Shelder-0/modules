package com.example.modules.fileModules.directory;

import com.example.modules.exceptions.FileModuleException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public class DirectorySizeFileModule extends AbstractDirectoryFileModule {

    @Override
    public String getDescription() {
        return "Подсчет размера всех файлов в каталоге";
    }

    @Override
    public String getResult(File file, String arg) throws FileModuleException {
        long size;

        try (Stream<Path> walk = Files.walk(file.toPath())) {
            size = walk.filter(Files::isRegularFile)
                       .mapToLong(path -> {
                           try {
                               return Files.size(path);
                           } catch (IOException e) {
                               return 0L;
                           }
                       })
                       .sum();
        } catch (IOException e) {
            throw new FileModuleException(e);
        }

        return String.valueOf(String.format("%s Kb", size / 1024));
    }
}
