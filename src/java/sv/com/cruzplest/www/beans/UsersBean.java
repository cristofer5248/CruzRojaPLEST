/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.model.UserModel;
import sv.com.cruzplest.www.entities.UsersEntity;
import sv.com.cruzplest.www.utils.JsfUtil;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@ViewScoped
public class UsersBean {

    private UserModel model = new UserModel();
    private UsersEntity users;
    private String pass;
    private String pass2;
    private String oldpass;

    /**
     * Creates a new instance of UsersBean
     */
    public UsersBean() {
        users = new UsersEntity();
    }

    public List<UsersEntity> listarAll() {
        return model.listarAll();
    }

    public void changeEmail() {
        System.out.print("Cambiando correo...");
        FacesContext context = FacesContext.getCurrentInstance();
        UsersEntity usersMail = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        usersMail.setCorreo("nuevooo");
        model.changeEmail(usersMail);
    }

    public void updateUser() {
    }

    /**
     * @return the users
     */
    public UsersEntity getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(UsersEntity users) {
        this.users = users;
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

    /**
     * @return the pass2
     */
    public String getPass2() {
        return pass2;
    }

    /**
     * @param pass2 the pass2 to set
     */
    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    /**
     * @return the oldpass
     */
    public String getOldpass() {
        return oldpass;
    }

    /**
     * @param oldpass the oldpass to set
     */
    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

}
