package io.github.clairtonluz.rmi_2_fases.client;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.task.Read;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeClient {
    public static void main(String args[]) {
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);;
            Read read = new Read("/home/clairton/teste.txt");
            comp.executeTask(read);
            System.out.println("FIM");
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
