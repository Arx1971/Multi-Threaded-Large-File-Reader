package com.large.file.cutomfilewriter;

public class GenerateFile implements Runnable {

    private final String filePath;
    private final Long numberOfCharacters;
    private final CustomFileWriter customFileWriter;
    private Thread thread;
    private String threadName;

    public GenerateFile(String filePath, String threadName, Long numberOfCharacters) {
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
        this.threadName = threadName;
        this.customFileWriter = new CustomFileWriter(this.filePath, this.threadName, this.numberOfCharacters);
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        /*synchronized (customFileWriter) {
            customFileWriter.largeFileWriter();
        }*/
        customFileWriter.largeFileWriter();
    }
}
