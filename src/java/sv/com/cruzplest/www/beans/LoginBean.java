/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzroja.beans;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String user;
    private String pass;

    public LoginBean() {
    }

    public void iniciarsesion() {
        System.out.print("estoy aqui");
        
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}
