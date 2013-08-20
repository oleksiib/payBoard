package com.payment.service;

import com.payment.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 31.03.13
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public interface BalanceService {

//    List findById(Integer id);

    List findByEmail(String username);

    BigDecimal findCurrentBalanceForUser(String username);

    List findCurrentBalanceForAll();

    List findAll();

    List findAllBetweeenDates(String startDate, String endDate);

}
