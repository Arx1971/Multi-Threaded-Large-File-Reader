package com.large.file.cutomfilewriter;

public class GenerateFile implements Runnable{

    private final String filePath;
    private final Long numberOfCharacters;
    private final String fileName;
    private final Integer numberOfThreads;

    public GenerateFile(String filePath, String fileName, Long numberOfCharacters, Integer numberOfThreads) {
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
        this.numberOfThreads = numberOfThreads;
        this.fileName = fileName;
        generateFile();
    }

    public void generateFile() {

    }

    @Override
    public void run() {

    }
}
