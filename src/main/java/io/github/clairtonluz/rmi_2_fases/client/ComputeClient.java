package io.github.clairtonluz.rmi_2_fases.client;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.constants.Name;
import io.github.clairtonluz.rmi_2_fases.task.Read;
import io.github.clairtonluz.rmi_2_fases.task.Write;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputeClient {

    public static final String FILE_PATH = "/home/clairton/teste.txt";

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", Name.CORDENADOR.getPort());
            Compute remoteCompute = (Compute) registry.lookup(Name.CORDENADOR.name());

            boolean continuar = true;
            System.out.println("Ler arquivo: 1");
            System.out.println("Escrever arquivo: 2");
            System.out.println("Sair: -1");

            while (continuar) {
                System.out.print("/>: ");
                String option = sc.next();
                switch (option) {
                    case "1": {
                        Read read = new Read(FILE_PATH);
                        System.out.println(remoteCompute.executeTask(read));
                        break;
                    }
                    case "2": {
                        System.out.println("Escreva seu texto quanto acabar digite 'quit' para sair");
                        StringBuilder sb = new StringBuilder();
                        String line = "";
                        boolean exit = false;
                        while (!exit) {
                            line = sc.nextLine();
                            if (line.equalsIgnoreCase("quit")) {
                                exit = true;
                                continue;
                            }
                            sb.append(line).append(System.getProperty("line.separator"));
                        }
                        if (sb.length() > 0) {
                            Write write = new Write(FILE_PATH, sb.toString());
                            System.out.println(remoteCompute.executeTask(write));
                        }
                        break;
                    }
                    case "-1": {
                        System.out.println("Saindo...");
                        continuar = false;
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
