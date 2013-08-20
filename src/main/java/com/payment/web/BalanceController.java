package com.payment.web;

import com.payment.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 30.03.13
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/balance")
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @RequestMapping(value = "/secure/addMoney.htm")
    public String addMoney() {
        return "balance/addMoney";
    }

    @RequestMapping(value = "/viewBalance.htm")
    public ModelAndView viewBalance(final HttpServletRequest request, Principal principal) {
        final String currentUser = principal.getName();
        BigDecimal amount = balanceService.findCurrentBalanceForUser(currentUser);
        ModelAndView modelAndView = new ModelAndView("balance/viewBalance");
        modelAndView.addObject("amount", amount);
        return modelAndView;
    }

    @RequestMapping(value = "/balanceHistory.htm")
    public ModelAndView viewBalanceHistory() {
        List balanceList = balanceService.findAll();
        ModelAndView modelAndView = new ModelAndView("balance/secure/balanceHistory");
        modelAndView.addObject("balanceList", balanceList);
        return modelAndView;
    }

    @RequestMapping(value = "/balanceManager.htm")
    public ModelAndView viewBalanceManager() {
        List balanceList = balanceService.findCurrentBalanceForAll();
        ModelAndView modelAndView = new ModelAndView("balance/secure/balanceManager");
        modelAndView.addObject("balanceList", balanceList);
        return modelAndView;
    }

    @RequestMapping(value = "/balanceHistoryDateFilter.htm")
//    public ModelAndView balanceHistoryDateFilter(@PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date startDate,
//
//                                       @PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date endDate) {
    @ResponseBody
    public String  balanceHistoryDateFilter(final HttpServletRequest request){
        String startDate = request.getParameter("dateStart");
        String endDate = request.getParameter("dateEnd");

        List balanceList = balanceService.findAllBetweeenDates(startDate, endDate);
        ModelAndView modelAndView = new ModelAndView("balance/secure/balanceManager");
//        modelAndView.addObject("balanceList", balanceList);
        return "sdfsd";
    }

//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String keyword = request.getParameter("keyword");
//        if (keyword != null) {
//            if (!StringUtils.hasLength(keyword)) {
//                return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
//            }
//            PagedListHolder productList = new PagedListHolder(balanceService.findCurrentBalanceForAll());
//            productList.setPageSize(10);
//            request.getSession().setAttribute("SearchProductsController_productList", productList);
//            return new ModelAndView("SearchProducts", "productList", productList);
//        }
//        else {
//            String page = request.getParameter("page");
//            PagedListHolder productList = (PagedListHolder) request.getSession().getAttribute("SearchProductsController_productList");
//            if (productList == null) {
//                return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
//            }
//            if ("next".equals(page)) {
//                productList.nextPage();
//            }
//            else if ("previous".equals(page)) {
//                productList.previousPage();
//            }
//            return new ModelAndView("SearchProducts", "productList", productList);
//        }
//    }



}
