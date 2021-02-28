package com.large.file.filereader;

import java.io.*;

public class FileTransformProcessor {

    private final String sourcePath;
    private final String destinationPath;
    private final String fileName;

    public FileTransformProcessor(String sourcePath, String destinationPath, String fileName) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.fileName = fileName;
    }

    public void fileTransformer() throws IOException {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        
        try {

            bufferedReader = new BufferedReader(
                    new FileReader(sourcePath + fileName));

            bufferedWriter = new BufferedWriter(
                    new FileWriter(destinationPath + fileName));

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
            }

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }finally {
            assert bufferedReader != null;
            bufferedReader.close();
            bufferedWriter.close();

        }

    }

}
