package com.large.file.filereader;

import java.io.IOException;

public class FileProcessor implements Runnable{

    private String fileName;
    private String fileSourcePath;
    private String fileDestinationPath;
    private FileTransformer fileTransformer;
    private Thread thread;

    public FileProcessor(String fileName, String fileSourcePath, String fileDestinationPath) {
        this.fileName = fileName;
        this.fileSourcePath = fileSourcePath;
        this.fileDestinationPath = fileDestinationPath;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (fileTransformer){
            try {
                fileTransformer.fileTransformer();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
