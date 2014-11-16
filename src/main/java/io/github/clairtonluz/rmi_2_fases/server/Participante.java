package io.github.clairtonluz.rmi_2_fases.server;

import io.github.clairtonluz.rmi_2_fases.compute.Compute;
import io.github.clairtonluz.rmi_2_fases.compute.Server;
import io.github.clairtonluz.rmi_2_fases.compute.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.DayOfWeek;


public class Participante extends Server {

    public Participante(String name, int port) {
        super(name, port);
    }
}
