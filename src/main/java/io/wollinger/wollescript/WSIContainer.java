package io.wollinger.wollescript;

import io.wollinger.wollescript.function.WSFunction;
import io.wollinger.wollescript.variable.WSIVariable;

public interface WSIContainer {
    boolean hasVariable(String identifier);
    void setVariable(String identifier, WSIVariable variable);
    WSIVariable getVariable(String identifier);

    boolean hasFunction(String identifier);
    void setFunction(String identifier, WSFunction function);
    WSFunction getFunction(String identifier);
}
