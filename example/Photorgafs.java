package org.example;

import javax.persistence.*;
@Entity
@Table(name = "Photorgafs")
@NamedQuery(name = "Photorgafs.getAll", query = "SELECT s from Photorgafs s")

public class Photorgafs {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name="isDelete")
    private boolean isDelete;

    public Photorgafs(int id, String name, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
    }

        public Photorgafs() {}
    public int getId() {
        return id;
    }
	public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isDelete() {
        return isDelete;
    }
    public void setDelete(boolean deleted) {
        isDelete = deleted;
    }
}