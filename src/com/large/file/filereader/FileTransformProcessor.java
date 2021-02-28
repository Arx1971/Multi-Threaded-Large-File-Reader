package com.large.file.filereader;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class FileTransformProcessor {

    private final String sourcePath;
    private final String destinationPath;
    private final FileNameReader fileNameReader;

    public FileTransformProcessor(String sourcePath, String destinationPath) throws FileNotFoundException {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.fileNameReader = new FileNameReader(sourcePath);
        transformAllFiles();
    }

    public void transformAllFiles() throws FileNotFoundException {
        Set<String> allFiles = this.fileNameReader.getAllFileNames();
        int numberOfProcessorToRun = allFiles.size();
        System.out.println(allFiles);
        FileReaderProcessor[] fileReaderProcessors = new FileReaderProcessor[numberOfProcessorToRun];

        AtomicInteger fileCounter = new AtomicInteger();

        allFiles.forEach(fileName -> {
            fileReaderProcessors[fileCounter.getAndIncrement()] =
                    new FileReaderProcessor(fileName, this.sourcePath, this.destinationPath);
        });

        for (int i = 0; i < numberOfProcessorToRun; i++) {
            try {
                fileReaderProcessors[i].getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
