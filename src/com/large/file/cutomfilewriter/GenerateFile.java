package com.large.file.cutomfilewriter;

public class GenerateFile implements Runnable {

    private final String filePath;
    private final Long numberOfCharacters;
    private final CustomFileWriter customFileWriter;
    private Thread thread;

    public GenerateFile(String filePath, Long numberOfCharacters) {
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
        this.customFileWriter = new CustomFileWriter(this.filePath, this.numberOfCharacters);
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        synchronized (customFileWriter) {
            customFileWriter.largeFileWriter();
        }
    }
}
