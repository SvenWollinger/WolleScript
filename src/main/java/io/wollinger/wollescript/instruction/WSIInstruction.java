package io.wollinger.wollescript.instruction;

import io.wollinger.wollescript.function.WSFunction;

public interface WSIInstruction {
    void execute(WSFunction function);
    int getLine();
}
