package io.github.clairtonluz.rmi_2_fases;

import io.github.clairtonluz.rmi_2_fases.compute.Server;
import io.github.clairtonluz.rmi_2_fases.constants.Name;
import io.github.clairtonluz.rmi_2_fases.server.Coordenador;
import io.github.clairtonluz.rmi_2_fases.server.Participante;

/**
 * Created by clairton on 11/15/14.
 */
public class P1 {

    public static void main(String[] args) {
        Server p1 = new Participante(Name.PARTICIPANTE_1.name(), Name.PARTICIPANTE_1.getPort());
        p1.iniciarServer();
    }

}
