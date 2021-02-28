package com.large.file.filereader;

import java.io.IOException;

public class FileReaderProcessor implements Runnable {

    private String fileName;
    private String fileSourcePath;
    private String fileDestinationPath;
    private final FileTransformer fileTransformer;
    private final Thread thread;

    public FileReaderProcessor(String fileName, String fileSourcePath, String fileDestinationPath) {
        this.fileName = fileName;
        this.fileSourcePath = fileSourcePath;
        this.fileDestinationPath = fileDestinationPath;
        fileTransformer = new FileTransformer(fileSourcePath, fileDestinationPath, fileName);
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            fileTransformer.fileTransformer();
        } catch (IOException exception) {
            System.out.println("FILE TRANSFORMER IS BROKEN");
            exception.printStackTrace();
        }
    }
}
