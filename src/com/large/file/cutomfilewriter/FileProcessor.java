package com.large.file.cutomfilewriter;

public class FileProcessor {

    private final Integer numberFileToGenerate;
    private final String filePath;
    private final Long numberOfCharacters;

    public FileProcessor(String filePath, Long numberOfCharacters, Integer numberFileToGenerate) {
        this.numberFileToGenerate = numberFileToGenerate;
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
        triggerFileProcessor();
    }

    public void triggerFileProcessor() {
        Thread[] threads = new Thread[this.numberFileToGenerate];
        for (int i = 0; i < this.numberFileToGenerate; i++) {
            GenerateFile generateFile = new GenerateFile(this.filePath, this.numberOfCharacters);
            threads[i] = new Thread(generateFile);
            threads[i].start();
        }
        for (int i = 0; i < this.numberFileToGenerate; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
