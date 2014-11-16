package io.github.clairtonluz.rmi_2_fases.constants;

/**
 * Created by clairton on 11/15/14.
 */
public enum Name {
    CORDENADOR, PARTICIPANTE_1, PARTICIPANTE_2;

    public int getPort() {
        return ordinal() + 1099;
    }
}
