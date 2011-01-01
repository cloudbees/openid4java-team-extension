package com.cloudbees.openid4java.team;

import org.openid4java.message.MessageExtension;
import org.openid4java.message.ParameterList;

/**
 * @author Kohsuke Kawaguchi
 */
public abstract class TeamExtensionMessage implements MessageExtension {
    protected ParameterList params;

    protected TeamExtensionMessage(ParameterList parameterList) {
        this.params = parameterList;
    }

    protected TeamExtensionMessage() {
        this.params = new ParameterList();
    }

    public String getTypeUri() {
        return "http://ns.launchpad.net/2007/openid-teams";
    }

    public ParameterList getParameters() {
        return params;
    }

    public void setParameters(ParameterList params) {
        this.params = params;
    }

    public boolean signRequired() {
        return false;
    }

    public boolean providesIdentifier() {
        return false;
    }
}
