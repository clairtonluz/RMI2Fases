package io.github.clairtonluz.rmi_2_fases.compute;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Server implements Compute {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String name;
    private int port;
    private File fileLog;

    public Server(String name, int port) {
        super();
        this.name = name;
        this.port = port;
        this.fileLog = new File(String.format("%s/%s%s", System.getProperty("user.home"), name, ".log"));
    }

    @Override
    public <T> T executeTask(Task<T> t) {
        System.out.printf("Executando no %s:%d%n", this.name, this.port);
        T retorno = t.execute();
        log(t);
        return retorno;
    }

    protected <T> void log(Task<T> t) {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDateTime.now().format(FORMATTER));
        sb.append(t.isSucesso() ? " [SUCESSO] " : " [FAIL] ");
        sb.append("TIPO: ");
        sb.append(t.getTipo());

        sb.append(System.getProperty("line.separator"));
        writeLog(sb.toString());
    }

    private void writeLog(String log) {
        try {
            Files.write(fileLog.toPath(), log.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void iniciarServer() {
        registrarRMI();
        try {
            Compute stub = (Compute) UnicastRemoteObject
                    .exportObject(this, 0);
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
