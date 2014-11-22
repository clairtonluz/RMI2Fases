package io.github.clairtonluz.rmi_2_fases.compute;

/**
 * Created by clairton on 11/15/14.
 */
public interface Task<T> {
    T execute();
    char getTipo();
    boolean isSucesso();
}