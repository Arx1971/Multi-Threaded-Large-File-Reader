package com.large.file;

import com.large.file.cutomfilewriter.FileProcessor;

public class Application {

    public static void main(String[] args) {
        String filePath = "c:/Users/rahin/online/customwriter/";

        FileProcessor fileProcessor =
                new FileProcessor(filePath, 102030L, 100);

    }

}
