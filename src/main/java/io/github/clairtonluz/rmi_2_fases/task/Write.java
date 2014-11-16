package io.github.clairtonluz.rmi_2_fases.task;

import io.github.clairtonluz.rmi_2_fases.compute.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

/**
 * Created by clairton on 11/15/14.
 */
public class Write implements Task<String>, Serializable {
    private static final long serialVersionUID = 227L;

    private File file;
    private StringBuilder text;

    public Write(String file, StringBuilder text) {
        super();
        this.file = new File(file);
        this.text = text;
    }

    @Override
    public String execute() {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
