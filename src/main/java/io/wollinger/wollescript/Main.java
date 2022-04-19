package io.wollinger.wollescript;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        WSParser.parse(WSFileLoader.loadFile(new File("TestFile.wscript")));
    }
}
