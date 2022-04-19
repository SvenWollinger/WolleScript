package io.wollinger.wollescript;

import io.wollinger.wollescript.function.WSFunction;
import io.wollinger.wollescript.instruction.WSIInstruction;
import io.wollinger.wollescript.variable.WSIVariable;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WSRuntime implements WSIContainer {
    private final HashMap<String, WSIVariable> variables = new HashMap<>();
    private final HashMap<String, WSFunction> functions = new HashMap<>();

    private final ArrayList<WSIInstruction> instructions = new ArrayList<>();

    public WSRuntime(File file) {
        parse(WSFileLoader.loadFile(file));
    }

    private void parse(String code) {
        //Split into instructions
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

    public void complainAndCrash(int line, String message) {
        System.out.println("Fatal error!\n" + line + ": " + message);
    }

    @Override
    public boolean hasVariable(String identifier) {
        return variables.containsKey(identifier);
    }

    @Override
    public void setVariable(String identifier, WSIVariable variable) {
        variables.put(identifier, variable);
    }

    @Override
    public WSIVariable getVariable(String identifier) {
        return variables.get(identifier);
    }

    @Override
    public boolean hasFunction(String identifier) {
        return functions.containsKey(identifier);
    }

    @Override
    public void setFunction(String identifier, WSFunction function) {
        functions.put(identifier, function);
    }

    @Override
    public WSFunction getFunction(String identifier) {
        return functions.get(identifier);
    }
}
