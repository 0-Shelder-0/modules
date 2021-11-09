package com.example.modules.extensions;

import java.io.File;

public class AudioFileModuleExtensions {

    public static String ValidateArg(String arg) {
        String result = null;

        if (arg == null || arg.length() == 0) {
            result = "Путь до ffmpeg не введен";
        }

        File ffmpegFile = new File(arg);
        if (!ffmpegFile.exists()) {
            result = "Некорректный путь к ffmpeg";
        }

        return result;
    }
}
