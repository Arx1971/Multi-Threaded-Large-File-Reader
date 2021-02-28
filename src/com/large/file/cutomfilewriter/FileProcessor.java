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
        FileGenerator[] fileGenerators = new FileGenerator[numberFileToGenerate];
        for (int i = 0; i < numberFileToGenerate; i++) {
            fileGenerators[i] = new FileGenerator(filePath, String.valueOf(i), numberOfCharacters);
            fileGenerators[i].getThread().start();
        }
        for (int i = 0; i < numberFileToGenerate; i++) {
            try {
                fileGenerators[i].getThread().join();
            } catch (InterruptedException e) {
                System.out.println("Thread Is Interrupted Exception");
                e.printStackTrace();
            }
        }
    }

}
