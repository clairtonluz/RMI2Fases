package io.github.clairtonluz.rmi_2_fases.client;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.constants.Name;
import io.github.clairtonluz.rmi_2_fases.task.Read;
import io.github.clairtonluz.rmi_2_fases.task.Write;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeClient {

    public static final String FILE_PATH = "/home/clairton/teste.txt";

    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", Name.CORDENADOR.getPort());
            Compute comp = (Compute) registry.lookup(Name.CORDENADOR.name());
            Read read = new Read(FILE_PATH);
            StringBuilder sb = new StringBuilder();
            sb.append("Testando escrita em arquivo");

            Write write = new Write(FILE_PATH, sb);
            comp.executeTask(write);
            System.out.println("FINISH");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
