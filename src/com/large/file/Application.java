package com.large.file;

import com.large.file.cutomfilewriter.GenerateFile;

public class Application {

    public static void main(String[] args) {
        String filePath = "c:/Users/rahin/online/customwriter/";
        GenerateFile generateFile =
                new GenerateFile(filePath
                        , 2000000L, 100);

    }

}
