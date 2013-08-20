package com.payment.dto;



//import javax.persistence.Column;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: AlexHome
 * Date: 31.03.13
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO {

//    @NotNull
//    @Pattern(regexp="\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")
    private String username;

//    @NotNull
    private String password;
//    @NotNull
    private String passwordConfirm;

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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
