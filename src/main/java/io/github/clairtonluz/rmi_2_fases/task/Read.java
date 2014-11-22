package io.github.clairtonluz.rmi_2_fases.task;

import io.github.clairtonluz.rmi_2_fases.compute.Task;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

/**
 * Created by clairton on 11/15/14.
 */
public class Read implements Task<String>, Serializable {

    private static final long serialVersionUID = 2272L;

    private File file;
    private boolean sucesso;

    public Read(String file) {
        super();
        this.file = new File(file);
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(file.toPath())
                    .forEach(s -> sb.append(s).append(System.getProperty("line.separator")));
            setSucesso(true);
        } catch (IOException e) {
            setSucesso(false);
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    public char getTipo() {
        return 'R';
    }

    @Override
    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
