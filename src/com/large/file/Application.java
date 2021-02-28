package com.large.file;

import com.large.file.cutomfilewriter.FileProcessor;
import com.large.file.filereader.FileNameReader;
import com.large.file.filereader.FileTransformProcessor;

import java.io.IOException;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        String filePath = "c:/Users/rahin/online/customwriter/";

        FileProcessor fileProcessor =
                new FileProcessor(filePath, 42949672L, 1000);

        long end = System.currentTimeMillis();

        Set<String> fileNames = new FileNameReader(filePath).getAllFileNames();

        System.out.println(fileNames);


        FileTransformProcessor fileTransformProcessor =
                new FileTransformProcessor(filePath,
                        "c:/Users/rahin/online/output/");

        double time = (end - start) / 1000.0;

        System.out.println("Total Time to Execute " + time + " Seconds");

    }

}
