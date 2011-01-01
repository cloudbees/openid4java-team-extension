package com.cloudbees.openid4java.team;

import org.openid4java.message.Parameter;
import org.openid4java.message.ParameterList;

import java.util.Collection;

/**
 * Request from client to server to ask for group membership.
 *
 * @author Kohsuke Kawaguchi
 */
public class TeamExtensionRequest extends TeamExtensionMessage {
    public TeamExtensionRequest(ParameterList parameterList) {
        super(parameterList);
    }

    public TeamExtensionRequest() {
    }

    /**
     * List of team names to query.
     */
    public void setQueryMembership(Collection<String> teams) {
        StringBuffer buf = new StringBuffer();
        for (String team : teams) {
            if (buf.length()>0)
                buf.append(',');
            buf.append(team);
        }
        params.set(new Parameter("query_membership",buf.toString()));
    }
}
