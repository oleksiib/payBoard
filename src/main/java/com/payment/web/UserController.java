package com.payment.web;

import com.payment.dto.UserDTO;
import com.payment.model.Person;
import com.payment.model.User;
import com.payment.model.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import javax.validation.Valid;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 31.03.13
 * Time: 12:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/registration.htm")
     public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/registration.htm", method = RequestMethod.POST)
    public ModelAndView addUser(//@Valid
                                    UserDTO userDTO, Errors errors) {
        if (userDTO != null) {

            if(userDTO.getUsername()!=null){
//                errors.rejectValue();
            }

            if(!userDTO.getPassword().equals(userDTO.getPasswordConfirm())){

            }
        }

        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("registration");
            mav.addObject("errors", errors);
            return mav;
        }

        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setDateCreated(new Date());

        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        userRole.setUser(user);

        Set<UserRole> roles = new HashSet<UserRole>();
        roles.add(userRole);
        user.setAuthorities(roles);

        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(userRole);

        return new ModelAndView("redirect:/signIn.htm");
    }

    @RequestMapping(value = "/signIn.htm")
    public String signIn() {
        return "signIn";
    }

}
