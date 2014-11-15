package io.github.clairtonluz.rmi_2_fases.task;

import io.github.clairtonluz.rmi_2_fases.compute.Task;

import java.io.Serializable;

/**
 * Created by clairton on 11/15/14.
 */
public class Write implements Task<String>, Serializable {
    private static final long serialVersionUID = 227L;

    @Override
    public String execute() {
        return null;
    }
}
