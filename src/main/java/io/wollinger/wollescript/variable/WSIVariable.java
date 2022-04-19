package io.wollinger.wollescript.variable;

public interface WSIVariable {
    public Object getValue();

    public WSIVariable plus(WSIVariable variable);
    public WSIVariable minus(WSIVariable variable);

    public WSIVariable plusEquals(WSIVariable variable);
    public WSIVariable minusEquals(WSIVariable variable);
}
