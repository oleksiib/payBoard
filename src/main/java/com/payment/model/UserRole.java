package com.payment.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 31.03.13
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "authorities")
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @Column(name = "authority")
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
