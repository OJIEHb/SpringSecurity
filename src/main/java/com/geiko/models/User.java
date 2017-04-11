package com.geiko.models;

import javax.persistence.*;
import java.util.List;


/**
 * Created by Андрей on 10.04.2017.
 */
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue
    int id;

    @Column
    String username;

    @Column
    String password;

    @Column
    boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
            @JoinColumn(name = "role_id")
    })
    List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
