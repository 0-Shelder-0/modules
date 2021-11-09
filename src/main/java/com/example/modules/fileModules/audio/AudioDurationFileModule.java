package com.example.modules.fileModules.audio;

import com.example.modules.exceptions.FileModuleException;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import static com.example.modules.extensions.AudioFileModuleExtensions.ValidateArg;

@Component
public class AudioDurationFileModule extends AbstractAudioFileModule {

    @Override
    public String getDescription() {
        return "Вывод длительности в секундах";
    }

    @Override
    public String getResult(File file, String arg) throws FileModuleException {
        String result;

        String message = ValidateArg(arg);
        if (message != null) {
            throw new FileModuleException(message);
        }

        try {
            FFprobe ffprobe = new FFprobe(arg);
            FFmpegProbeResult probeResult = ffprobe.probe(file.getAbsolutePath());
            FFmpegFormat format = probeResult.getFormat();
            result = String.format("Duration: %ss", format.duration);
        } catch (IOException e) {
            throw new FileModuleException(e);
        }

        return result;
    }
}