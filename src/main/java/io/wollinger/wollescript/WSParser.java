package io.wollinger.wollescript;

import java.util.ArrayList;

public class WSParser {
    public static void parse(String code) {
        boolean inQuotes = false;
        ArrayList<String> instructions = new ArrayList<>();
        StringBuilder currentInstruction = new StringBuilder();
        for(int i = 0; i < code.length(); i++) {
            char currentChar = code.charAt(i);
            if(currentChar == '"') {
                inQuotes = !inQuotes;
            } else if(currentChar == ';') {
                if(inQuotes) {
                    currentInstruction.append(currentChar);
                } else {
                    instructions.add(currentInstruction.toString());
                    currentInstruction.setLength(0);
                }
            } else {
                currentInstruction.append(currentChar);
            }
        }
    }
}
