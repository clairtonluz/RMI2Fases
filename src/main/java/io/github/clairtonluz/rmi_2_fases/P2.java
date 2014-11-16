package io.github.clairtonluz.rmi_2_fases;

import io.github.clairtonluz.rmi_2_fases.compute.Server;
import io.github.clairtonluz.rmi_2_fases.constants.Name;
import io.github.clairtonluz.rmi_2_fases.server.Coordenador;
import io.github.clairtonluz.rmi_2_fases.server.Participante;

/**
 * Created by clairton on 11/15/14.
 */
public class P2 {

    public static void main(String[] args) {
        Server p2 = new Participante(Name.PARTICIPANTE_2.name(), Name.PARTICIPANTE_2.getPort());
        p2.iniciarServer();
    }

}
