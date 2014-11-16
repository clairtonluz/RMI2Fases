package io.github.clairtonluz.rmi_2_fases.task;

import io.github.clairtonluz.rmi_2_fases.compute.Task;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by clairton on 11/15/14.
 */
public class Write implements Task<String>, Serializable {
    private static final long serialVersionUID = 227L;

    private String file;
    private String text;

    public Write(String file, String text) {
        super();
        this.file = file;
        this.text = text;
    }

    @Override
    public String execute() {
        try {
            Files.write(new File(file).toPath(), text.getBytes());
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
