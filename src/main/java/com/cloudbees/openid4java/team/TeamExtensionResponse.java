package com.cloudbees.openid4java.team;

import org.openid4java.message.ParameterList;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kohsuke Kawaguchi
 */
public class TeamExtensionResponse extends TeamExtensionMessage {
    public TeamExtensionResponse(ParameterList parameterList) {
        super(parameterList);
    }

    public TeamExtensionResponse() {
    }

    public List<String> getTeamMembership() {
        return Arrays.asList(params.getParameterValue("is_member").split(","));
    }
}
