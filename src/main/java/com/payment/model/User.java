package com.payment.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 30.03.13
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @OneToMany(mappedBy="user")
    Set<UserRole> authorities;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<UserRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserRole> authorities) {
        this.authorities = authorities;
    }
}
