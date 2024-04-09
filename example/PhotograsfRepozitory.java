package org.example;

import org.example.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotograsfRepozitory implements IRepo<Photorgafs> {

public EntityManager em =
            Persistence.createEntityManagerFactor ("TSTS").createEntityManager();

    @Override
    public void Update(Photorgafs photorgafs) throws SQLException {
        String str = String.format("UPDATE photorgafs SET id = %s, S_name = '%s' WHERE id = %s" ,
                photorgafs.getId(),
                photorgafs.getName(),
                photorgafs.getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }
    @Override
    public Integer Insert(Photorgafs photorgafs) throws SQLException {
        String str = String.format("INSERT INTO photorgafs (name, isDeleted) VALUES ('%s', %s)",
                photorgaf.getName(),
                photorgaf.setDeleted(false));
        this.executeRequest(str);
        try (ResultSet rs = this.getStatement(this.connectToDB()).executeQuery("SELECT MAX(id) FROM Photorgafs")) {
            while (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        }
    }
    @Override
    public void Delete(Photorgafs photorgafs) throws SQLException {
        String str = String.format("UPDATE Photorgafs SET isDeleted = true WHERE id = %s" , photorgafs.getId());
        this.executeRequest(str);
    }
    @Override
    public void executeRequest(String request) throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(request);
        stmt.close();
    }

    @Override
    public List<Photorgafs> getList() {
        TypedQuery<Photorgafs> namedQuery = em.createNamedQuery("Photorgafs.getAll", Photorgafs.class);
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