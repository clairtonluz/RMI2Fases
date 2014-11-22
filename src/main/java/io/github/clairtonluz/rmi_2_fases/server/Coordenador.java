package io.github.clairtonluz.rmi_2_fases.server;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.compute.Server;
import io.github.clairtonluz.rmi_2_fases.compute.Task;
import io.github.clairtonluz.rmi_2_fases.constants.Name;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Coordenador extends Server {
    private Name currentServer;

    public Coordenador(String name, int port) {
        super(name, port);
        currentServer = Name.PARTICIPANTE_1;
    }

    @Override
    public <T> T executeTask(Task<T> t) {
        return balance(t);
    }

    public <T> T balance(Task<T> t){
        T result1 = executarNoServer(Name.PARTICIPANTE_1, t);
        T result2 = executarNoServer(Name.PARTICIPANTE_2, t);
        return result2;
    }

    private <T> T executarNoServer(Name server, Task<T> t) {
        T retorno = null;
        try {
            Registry registry = LocateRegistry.getRegistry(server.getPort());
            Compute comp = (Compute) registry.lookup(server.name());
            retorno = comp.executeTask(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
