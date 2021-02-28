package com.large.file.cutomfilewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CustomFileWriter {

    private String filePath;
    private Long numberOfCharacters;
    private final String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS'.txt'").format(new Date());

    public CustomFileWriter() {
    }

    public CustomFileWriter(String filePath, Long numberOfCharacters) {
        this.filePath = filePath;
        this.numberOfCharacters = numberOfCharacters;
    }

    public synchronized void largeFileWriter() {

        Map<Integer, Character> characterMap = loadAllLetters();

        Random random = new Random();

        try (FileWriter fileWriter = new FileWriter(this.filePath + this.fileName)) {

            int charCounter = 0;

            for (int i = 0; i < numberOfCharacters; i++) {
                charCounter++;
                int rand = random.nextInt(51 + 1);
                fileWriter.write(characterMap.get(rand));
                if (charCounter == 150) {
                    fileWriter.write(System.lineSeparator());
                    charCounter = 0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(String fileName) {
        File file = new File(this.filePath + "/" + this.fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("checked")
    public Map<Integer, Character> loadAllLetters() {
        Map<Integer, Character> characterMap = new ConcurrentHashMap<>();

        int maxValue = 0;

        for (char a = 'A'; a <= 'Z'; a++) {
            characterMap.put((a - 'A'), a);
            maxValue = Math.max(maxValue, (a - 'A'));
        }

        for (char a = 'a'; a <= 'z'; a++) {
            characterMap.put((a - 'a') + 1 + maxValue, a);
        }

        return characterMap;
    }

}
