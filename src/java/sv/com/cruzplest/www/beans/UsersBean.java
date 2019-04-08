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
import sv.com.cruzplest.www.utils.LimitAttempts;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@ViewScoped
public class UsersBean {

    private UserModel model = new UserModel();
    private UsersEntity users = new UsersEntity();
    private String pass;
    private String pass2;
    private String oldpass;
    private int genero;
    private UsersEntity userSession;
    private LimitAttempts limits = new LimitAttempts();

    /**
     * Creates a new instance of UsersBean
     */
    public UsersBean() {        
        FacesContext context = FacesContext.getCurrentInstance();
        userSession = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        users.setNombre(userSession.getNombre());
        users.setApellidos(userSession.getApellidos());
        users.setCorreo(userSession.getCorreo());
        users.setGenero(userSession.getGenero());
        users.setTelefono(userSession.getTelefono());

    }

    public String redirect2Ped() {        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "df";
    }

    public List<UsersEntity> listarAll() {
        try {
        List<UsersEntity> user = model.listarAll();
        return user;
        } catch (Exception e) {
            return null;
        }
        
    }

    public List<UsersEntity> listarInfo() {
        users = userSession;
        return model.listarInfo(userSession.getCodigouser());
    }

    public void changeEmail() {
        System.out.print("Cambiando correo...");
        FacesContext context = FacesContext.getCurrentInstance();
        UsersEntity usersMail = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        usersMail.setCorreo("nuevooo");
        model.changeEmail(usersMail);
    }

    public String updateUser() {
        try {
            if (!getPass().equals(getPass2())) {
                return "about?faces-redirect=true&op=pne";
            }
            if (!model.verificarcontraseña(userSession.getCodigouser(), getOldpass())) {
                return "about?faces-redirect=true&op=one";
            }
            //Si se quiere cambiar los limites de intentos para un usuarios se cambia en la clase LimitAttempts
            int userLimit = limits.getAttemptsUser();
            if (model.verificarIntentos(userSession.getCodigouser()) >= userLimit) {
                return "about?faces-redirect=true&op=limit";
            }
            users.setPass(getPass());
            model.updateUser(users);
            return "about?faces-redirect=true&op=yes";

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

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

    /**
     * @return the genero
     */
    public int getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(int genero) {
        this.genero = genero;
    }

}
