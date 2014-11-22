package io.github.clairtonluz.rmi_2_fases.constants;

import java.io.File;
import java.io.IOException;

/**
 * Created by clairton on 11/15/14.
 */
public enum Name {

    CORDENADOR, PARTICIPANTE_1, PARTICIPANTE_2;

    private static final String HOME = System.getProperty("user.home");

    Name() {
    }

    public int getPort() {
        return ordinal() + 1099;
    }

    public File getFile() {
        File file = new File(String.format("%s/%s.txt", HOME, name()));
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
