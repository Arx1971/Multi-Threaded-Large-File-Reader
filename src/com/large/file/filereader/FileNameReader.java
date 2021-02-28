package com.large.file.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class FileNameReader {

    private final String filePath;

    public FileNameReader(String filePath) {
        this.filePath = filePath;
    }

    public Set<String> getAllFileNames() throws FileNotFoundException {

        File[] files = new File(this.filePath).listFiles();

        if (files == null || files.length == 0) {
            throw new FileNotFoundException(filePath + " Is Empty");
        }

        Set<String> fileNames = new HashSet<>();

        for (File file : files) {
            fileNames.add(file.getName());
        }

        return fileNames;
    }

}
