package io.wollinger.wollescript;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        new WSRuntime(new File("TestFile.wscript"));
    }
}
