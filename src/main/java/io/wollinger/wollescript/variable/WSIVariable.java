package io.wollinger.wollescript.variable;

public interface WSIVariable {
    Object getValue();

    WSIVariable plus(WSIVariable variable);
    WSIVariable minus(WSIVariable variable);

    WSIVariable plusEquals(WSIVariable variable);
    WSIVariable minusEquals(WSIVariable variable);
}
