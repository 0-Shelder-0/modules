package com.example.modules.fileModules.audio;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import java.io.File;
import java.io.IOException;

public class AudioDurationFileModule extends AbstractAudioFileModule {

    @Override
    public String getDescription() {
        return "Вывод названия трека из тегов";
    }

    @Override
    public String getResult(File file, String arg) throws IOException {
        FFprobe ffprobe = new FFprobe(file.getParent());
        FFmpegProbeResult probeResult = ffprobe.probe(file.getName());

        FFmpegFormat format = probeResult.getFormat();
        String result = String.valueOf(format.duration);
        return result;
    }
}