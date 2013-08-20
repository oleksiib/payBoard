package com.payment.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 31.03.13
 * Time: 18:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private SessionFactory sessionFactory;

    public List findByEmail(String username) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Balance b where b.user = ?")
                .setString(0, username)
                .list();
    }

    public BigDecimal findCurrentBalanceForUser(String username) {
        return (BigDecimal)this.sessionFactory.getCurrentSession()
                .createQuery("select sum(b.money) from Balance b where b.user = ?")
                .setString(0, username)
                .uniqueResult();
    }

    public List findCurrentBalanceForAll() {
        return this.sessionFactory.getCurrentSession()
//                .createQuery("select sum(b.money), b.userID, max(b.saveMoneyDate) from Balance b  ")
                .createSQLQuery("SELECT u.username, SUM(IFNULL(b.money, 0)), u.dateCreated " +
                        "FROM  Users u left OUTER JOIN Balance b " +
                        "  ON u.username = b.userID" +
                        "  GROUP by u.username")
                .list();
    }

    public List findAll() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Balance b")
                .list();
    }

    public List findAllBetweeenDates(String startDate, String endDate) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Balance b where b.saveMoneyDate between '"+startDate+"' and '"+endDate+"'")
                .list();
    }

}
