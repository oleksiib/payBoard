package com.payment.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 30.03.13
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "BALANCE")
public class Balance {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "money")
    private BigDecimal money;

    @OneToOne
    @JoinColumn(name="editedById", nullable=false)
    private User editedBy;

    @OneToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @Column(name = "saveMoneyDate")
    private Date saveMoneyDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public User getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(User editedBy) {
        this.editedBy = editedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSaveMoneyDate() {
        return saveMoneyDate;
    }

    public void setSaveMoneyDate(Date saveMoneyDate) {
        this.saveMoneyDate = saveMoneyDate;
    }
}
