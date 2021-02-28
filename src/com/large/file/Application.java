package com.large.file;

import com.large.file.filereader.FileTransformProcessor;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        String filePath = "c:/Users/rahin/online/customwriter/";

        /*FileProcessor fileProcessor =
                new FileProcessor(filePath, 42949672L, 10);

        long end = System.currentTimeMillis();

        double time = (end - start) / 1000.0;

        System.out.println("Total Time to Execute " + time + " Seconds");

        Set<String> fileNames = new FileNameReader(filePath).getAllFileNames();

        System.out.println(fileNames);*/

        FileTransformProcessor fileTransformProcessor = new FileTransformProcessor(filePath,
                "c:/Users/rahin/online/output/",
                "CustomFile-0-2021-02-28-02-29-17-285.txt");

        fileTransformProcessor.fileTransformer();

    }

}
