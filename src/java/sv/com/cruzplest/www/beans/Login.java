/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.entities.UsersEntity;
import sv.com.cruzplest.www.model.UserModel;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@SessionScoped
public class Login {

    private String user;
    private String pass;

    /**
     * Creates a new instance of Login
     */
    public Login() {

    }

    public String iniciarsesion() {
        try {
            UserModel model = new UserModel();
            UsersEntity user;
            user = null;
            UsersEntity usernivel1;
            usernivel1 = null;
            user = model.login();
            if (user != null) {
                if (user.getPass().equals(pass)) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
//                    usernivel1 = model.verificarnivel(user);
//Descomentariar y hacer funcionar si existe falla de re-autentificacion de usuarios
//                    if (user.getTipou().getCodigousertype() == 1) {
//                        System.out.println("Usuario nivel 1 iniciado");
//                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nivel", usernivel1);
//                        return "user1/index";
//
//                    }

                }
            }
            System.out.print("entrando al metodo del iniciar session");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El usuario no existe"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?error=ErrU");
            return null;
        } catch (Exception e) {
            return null;
        }

    }

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
