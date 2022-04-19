package io.wollinger.wollescript.function;


import io.wollinger.wollescript.instruction.WSIInstruction;
import io.wollinger.wollescript.variable.WSIVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class WSFunction {
    private HashMap<String, WSIVariable> variables = new HashMap<>();
    private HashMap<String, WSFunction> functions = new HashMap<>();

    private ArrayList<WSIInstruction> instructions = new ArrayList<>();

    private Runtime runtime;
    private WSFunction parent;

    public WSFunction(Runtime runtime) {
        this.runtime = runtime;
        this.parent = null;
    }

    public WSFunction(Runtime runtime, WSFunction parent) {
        this.runtime = runtime;
        this.parent = parent;
    }

    public void execute() {
        for(WSIInstruction instruction : instructions) {
            instruction.execute(this);
        }
    }

    public Runtime getRuntime() {
        return runtime;
    }

    public WSFunction getParent() {
        return parent;
    }

    public WSIVariable getVariable(String identifier) {
        if(variables.containsKey(identifier)) {
            return variables.get(identifier);
        }
        //TODO: Throw error
        return null;
    }

    public WSFunction getFunction(String identifier) {
        if(functions.containsKey(identifier)) {
            return functions.get(identifier);
        }
        //TODO: Throw error
        return null;
    }

    public boolean hasVariable(String identifier) {
        return variables.containsKey(identifier);
    }

    public boolean hasFunction(String identifier) {
        return functions.containsKey(identifier);
    }

    public void setVariable(String identifier, WSIVariable variable) {
        variables.put(identifier, variable);
    }

    public void setFunction(String identifier, WSFunction function) {
        functions.put(identifier, function);
    }
}
