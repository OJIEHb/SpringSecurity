package com.geiko.models;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Андрей on 10.04.2017.
 */
@Entity
@Table(name = "role")
public class Role {



    @Id
    @GeneratedValue
    int id;

    @Column
    String  name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
}
