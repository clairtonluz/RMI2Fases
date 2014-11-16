package io.github.clairtonluz.rmi_2_fases;

import io.github.clairtonluz.rmi_2_fases.compute.Server;
import io.github.clairtonluz.rmi_2_fases.constants.Name;
import io.github.clairtonluz.rmi_2_fases.server.Coordenador;
import io.github.clairtonluz.rmi_2_fases.server.Participante;

/**
 * Created by clairton on 11/15/14.
 */
public class Main {

    public static void main(String[] args) {
        Server coordenador = new io.github.clairtonluz.rmi_2_fases.server.Coordenador(Name.CORDENADOR.name(), Name.CORDENADOR.getPort());
        Server p1 = new Participante(Name.PARTICIPANTE_1.name(), Name.PARTICIPANTE_1.getPort());
        Server p2 = new Participante(Name.PARTICIPANTE_2.name(), Name.PARTICIPANTE_2.getPort());

        coordenador.iniciarServer();
        p1.iniciarServer();
        p2.iniciarServer();
    }

}
