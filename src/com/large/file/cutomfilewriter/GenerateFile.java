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
        thread = new Thread(this);
        this.thread.setName(threadName);
        this.customFileWriter = new CustomFileWriter(this.filePath, thread.getName(), this.numberOfCharacters);
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        synchronized (customFileWriter) {
            customFileWriter.largeFileWriter();
        }
        //customFileWriter.largeFileWriter();
    }
}
