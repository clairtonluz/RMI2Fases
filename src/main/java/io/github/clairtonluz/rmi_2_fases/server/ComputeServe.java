package io.github.clairtonluz.rmi_2_fases.server;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.compute.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ComputeServe implements Compute {

    public ComputeServe() {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) {
        System.out.println("Running...");
        return t.execute();
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }
        try {
            String name = "Compute";
            Compute engine = new ComputeServe();
            Compute stub = (Compute) UnicastRemoteObject
                    .exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

}
