package org.example;
import javax.persistence.*;
@Entity
@Table(name = "Clients")
@NamedQuery(name = "Clients.getAll", query = "SELECT c from Clients c")
public class Clients {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_photorgafs")
    private Photorgafs id_photorgafs;
    @Column(name = "isDelete")
    private boolean isDelete;

    public Photorgafs(int id, String name, boolean isDeleted, Photorgafs id_photorgafs) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.id_photorgafs = id_photorgafs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photorgafs getIdPhotorgafs() {
        return id_photorgafs;
    }

    public void setIdPhotorgafs(Photorgafs id_photorgafs) {
        this.id_photorgafs = id_photorgafs;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}