package io.github.clairtonluz.rmi_2_fases.client;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.constants.Name;
import io.github.clairtonluz.rmi_2_fases.task.Read;
import io.github.clairtonluz.rmi_2_fases.task.Write;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComputeClient {

    public static final String FILE_PATH = "/home/clairton/teste.txt";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", Name.CORDENADOR.getPort());
            Compute remoteCompute = (Compute) registry.lookup(Name.CORDENADOR.name());
            ComputeClient client = new ComputeClient();

            client.ler(remoteCompute);
            client.escrever(remoteCompute);
            client.ler(remoteCompute);
            client.ler(remoteCompute);
            client.escrever(remoteCompute);
            client.escrever(remoteCompute);
            client.ler(remoteCompute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void escrever(Compute remoteCompute) throws java.rmi.RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Escrevendo as ").append(LocalDateTime.now().format(FORMATTER)).append(System.getProperty("line.separator"));
        Write write = new Write(FILE_PATH, sb.toString());
        remoteCompute.executeTask(write);
    }

    private void ler(Compute remoteCompute) throws java.rmi.RemoteException {
        Read read = new Read(FILE_PATH);
        System.out.println(remoteCompute.executeTask(read));
    }
}
