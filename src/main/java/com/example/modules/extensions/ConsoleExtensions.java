package com.example.modules.extensions;

import static com.example.modules.constants.ColorConstants.*;

public class ConsoleExtensions {

    public static void PrintError(String text) {
        System.out.printf("%sПроизошла ошибка:\n%s%s%n", ANSI_RED, text, ANSI_RESET);
    }

    public static void PrintInfo(String text) {
        System.out.println(text);
    }

    public static void PrintResult(String text) {
        System.out.printf("%s%s%s%n", ANSI_GREEN, text, ANSI_RESET);
    }
}
