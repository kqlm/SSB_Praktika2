package org.example;
import org.example.entity.*;
import org.example.repozitory.*;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        IRepo<Clients> clientsRepo = new ClientsRepozitory();
        IRepo<Photorgafs> stylistsRepo = new PhotograsfRepozitory();

        List<Clients> clients;
        List<Photorgafs> photorgafs;

        PhotograsfRepozitory.insert(new Photogras(null, "Анна", null));
        PhotograsRepozitory.insert(new Photogras(null, "Анастасия", null));

        Photogras = PhotograsRepozitory.getList();

        ClientsRepozitory.insert(new Clients(null, "Виктория", Photogras.get(1), null));
        ClientsRepozitory.insert(new Clients(null, "Валентина", Photogras.get(2), null));

        clients = ClientsRepozitory.getList();

        System.out.println("---------Список Клиентов---------");
            BD.printClient((Clients) clients); 

        System.out.println("---------Список фотографоф---------");
            BD.printMasters((Photogras) photogras);

        System.out.println("------Клиенты и их фотографы-------");
            BD.printClientPhotogras((Clients) clients);
    }
}