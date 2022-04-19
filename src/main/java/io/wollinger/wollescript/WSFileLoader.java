package io.wollinger.wollescript;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WSFileLoader {
    public static String loadFile(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            return new String(bytes);
        } catch(IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
