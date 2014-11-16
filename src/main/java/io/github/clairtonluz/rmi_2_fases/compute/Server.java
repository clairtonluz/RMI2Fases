package io.github.clairtonluz.rmi_2_fases.compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public abstract class Server implements Compute {

    private final String name;
    private int port;

    public Server(String name, int port) {
        super();
        this.name = name;
        this.port = port;
    }

    @Override
    public <T> T executeTask(Task<T> t) {
        System.out.printf("Executando no %s:%d%n", this.name, this.port);
        return t.execute();
    }

    public void iniciarServer() {
        registrarRMI();
        try {
            Compute stub = (Compute) UnicastRemoteObject
                    .exportObject(this, port);
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind(name, stub);
            System.out.printf("Server rodando %s:%d%n", this.name, this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registrarRMI() {
        try {
            LocateRegistry.createRegistry(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
