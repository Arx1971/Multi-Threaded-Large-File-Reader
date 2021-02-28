package com.large.file.filereader;

public class FileReader {

    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
