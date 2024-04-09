package org.example;
import java.util.List;

public class Bd {
    public static void printMasters(Photorgafs photorgafs) {
        System.out.println(photorgafs.getId() + " " + photorgafs.getName());
    }
    public static void printClient(Clients client) {
        System.out.println(client.getId() + " " + client.getName());
    }
    public static void printClientPhotorgafs(Clients client) {
        System.out.print(client.getId() + " " + client.getName());
        printPhotorgafs(client.getIdPhotorgafs());
    }
}