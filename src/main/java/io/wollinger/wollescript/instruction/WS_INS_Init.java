package io.wollinger.wollescript.instruction;

import io.wollinger.wollescript.function.WSFunction;
import io.wollinger.wollescript.variable.WSIVariable;

public class WS_INS_Init implements WSIInstruction {
    private final int line;
    private final String identifier;
    private final WSIVariable variable;

    public WS_INS_Init(int line, String identifier, WSIVariable variable) {
        this.line = line;
        this.identifier = identifier;
        this.variable = variable;
    }

    @Override
    public void execute(WSFunction function) {
        if(!function.hasVariable(identifier))
            function.setVariable(identifier, variable);
        else
            function.getRuntime().complainAndCrash(line, "Variable <" + identifier + "> already set!");
    }

    @Override
    public int getLine() {
        return line;
    }
}
