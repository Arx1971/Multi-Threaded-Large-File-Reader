package com.large.file;

import com.large.file.cutomfilewriter.FileProcessor;

public class Application {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        String filePath = "c:/Users/rahin/online/customwriter/";

        FileProcessor fileProcessor =
                new FileProcessor(filePath, 42949672L, 10);

        long end = System.currentTimeMillis();

        double time = (end - start) / 1000.0;

        System.out.println("Total Time to Execute " + time + " Seconds");

    }

}
