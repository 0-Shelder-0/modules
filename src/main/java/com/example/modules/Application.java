package com.example.modules;

import com.example.modules.exceptions.ApplicationException;
import com.example.modules.fileModules.FileModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.example.modules.extensions.ConsoleExtensions.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            File file = getFileAndThrowIfArgsNotValid(args);
            List<FileModule> supportedModules = getSupportedFileModules(file);

            printSupportedFileModules(supportedModules);

            Scanner scanner = new Scanner(System.in);
            String arg = null;

            String line = scanner.nextLine();
            String[] lineArgs = line.split("\s");
            int numCommand = Integer.parseInt(lineArgs[0]);
            if (lineArgs.length > 1) {
                arg = lineArgs[1];
            }

            PrintResult(supportedModules.get(numCommand - 1).getResult(file, arg));
        } catch (ApplicationException e) {
            PrintError(e.getMessage());
        }
    }

    private static void printSupportedFileModules(List<FileModule> supportedModules) {
        String typeDescription = null;
        Optional<String> s = supportedModules.stream().map(FileModule::getTypeDescription).distinct().findFirst();
        if (s.isPresent()) {
            typeDescription = s.get();
        }
        PrintInfo(typeDescription);

        for (int i = 0; i < supportedModules.size(); i++) {
            PrintInfo(String.format("%s. %s", i + 1, supportedModules.get(i).getDescription()));
        }
    }

    private static List<FileModule> getSupportedFileModules(File file) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        return ctx.getBeansOfType(FileModule.class)
                  .values()
                  .stream()
                  .filter(p -> p.supportExtension(file))
                  .sorted(Comparator.comparing(FileModule::getTypeDescription))
                  .collect(Collectors.toList());
    }

    private static File getFileAndThrowIfArgsNotValid(String[] args) throws ApplicationException {
        if (args.length == 0) {
            throw new ApplicationException("Приложение принимает в качестве аргумента командной строки имя файла");
        }
        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            throw new ApplicationException("Файл не найден");
        }

        return file;
    }
}
