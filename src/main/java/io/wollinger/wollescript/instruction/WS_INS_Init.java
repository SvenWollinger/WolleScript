package io.wollinger.wollescript.instruction;

import io.wollinger.wollescript.function.WSFunction;
import io.wollinger.wollescript.variable.WSIVariable;

public class WS_INS_Init implements WSIInstruction{
    private String identifier;
    private WSIVariable variable;

    public WS_INS_Init (String identifier, WSIVariable variable) {
        this.identifier = identifier;
        this.variable = variable;
    }

    @Override
    public void execute(WSFunction function) {
        function.setVariable(identifier, variable);
    }
}
