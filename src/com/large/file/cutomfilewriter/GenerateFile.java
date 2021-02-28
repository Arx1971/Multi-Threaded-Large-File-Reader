package com.large.file.cutomfilewriter;

public class GenerateFile implements Runnable {

    private final String filePath;
    private final Long numberOfCharacters;
    private final Integer numberOfThreads;
    private final CustomFileWriter customFileWriter;
    private Thread thread;

    public GenerateFile(String filePath, Long numberOfCharacters, Integer numberOfThreads) {
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
        this.numberOfThreads = numberOfThreads;
        this.customFileWriter = new CustomFileWriter(this.filePath, this.numberOfCharacters);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (customFileWriter) {
            customFileWriter.largeFileWriter();
        }
    }
}
