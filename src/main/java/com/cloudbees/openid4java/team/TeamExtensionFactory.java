package com.cloudbees.openid4java.team;

import org.openid4java.message.Message;
import org.openid4java.message.MessageException;
import org.openid4java.message.MessageExtension;
import org.openid4java.message.MessageExtensionFactory;
import org.openid4java.message.ParameterList;

/**
 * Databinding of OpenID team extension to the openid4java library.
 *
 * @author Kohsuke Kawaguchi
 */
public class TeamExtensionFactory implements MessageExtensionFactory {
    public static final String URI = "http://ns.launchpad.net/2007/openid-teams";

    public String getTypeUri() {
        return URI;
    }

    public MessageExtension getExtension(ParameterList parameterList, boolean isRequest) throws MessageException {
        if (isRequest)
            return new TeamExtensionRequest(parameterList);
        else
            return new TeamExtensionResponse(parameterList);
    }

    /**
     * Registers this extension to openid4java.
     */
    public static void install() {
        try {
            Message.addExtensionFactory(TeamExtensionFactory.class);
        } catch (MessageException e) {
            throw new Error(e);
        }
    }
}
