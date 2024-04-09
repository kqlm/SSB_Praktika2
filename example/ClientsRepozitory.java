package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsRepozitory implements IRepo<Clients> {
 public EntityManager em =
       Persistence.createEntityManagerFactor ("TSTS").createEntityManager();

    @Override
    public void Update(Clients client) throws SQLException {
        String str = String.format("UPDATE client SET idClient = %s, name = '%s', id_photorgafs = %s WHERE idClient = %s" ,
                client.getId(),
                client.getName(),
                client.getIdPhotorgafs().getId(),
                client.getId());
        this.executeRequest(str);

        // add stylists
    }
    @Override
    public void executeRequest(String request) throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(request);
        stmt.close();
    }

    @Override
    public int Insert(Clients client) throws SQLException {
        String str = String.format("INSERT INTO clients (name, idPhotorgafs) VALUES ('%s', '%s')",
                client.getName(),
                client.getIdPhotorgafs().getId(),
                client.setDelete(false);
        this.executeRequest(str);
        try (ResultSet rs = this.getStatement(this.connectToDB()).executeQuery("SELECT MAX(idClient) FROM Client")) {
            while (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        }
    }
    @Override
    public void Delete(Clients client) throws SQLException {
        String str = String.format("UPDATE Clients SET isDeleted = true WHERE id = %s" , client.getId());
        this.executeRequest(str);
    }

    @Override
    public List<Clients> getList(){
        TypedQuery<Clients> namedQuery = em.createNamedQuery("Clients.getAll", Clients.class);
        return namedQuery.getResultList();
    }
    
    @Override
    public Connection connectToDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:Photosalonnn","root","");
        if (conn==null) {
            System.out.println("Error with connection with DataBase!");
            System.exit(0);
        }
        return conn;
    }
    @Override
    public Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }
    public void closeConnection(Statement stmt) throws SQLException {
        stmt.close();
    }
}