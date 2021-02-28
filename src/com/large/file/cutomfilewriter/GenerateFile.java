package com.large.file.cutomfilewriter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateFile implements Runnable {

    private final String filePath;
    private final Long numberOfCharacters;
    private final String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.txt'").format(new Date());;
    private final Integer numberOfThreads;
    private final CustomFileWriter customFileWriter;

    public GenerateFile(String filePath, Long numberOfCharacters, Integer numberOfThreads) {
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
        this.numberOfThreads = numberOfThreads;
        this.customFileWriter = new CustomFileWriter(this.filePath, this.fileName, this.numberOfCharacters);
        generateFile();
    }

    public void generateFile() {
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(this);
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        synchronized (customFileWriter) {
            customFileWriter.largeFileWriter();
        }
    }
}
