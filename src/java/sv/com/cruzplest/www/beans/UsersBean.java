/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.com.cruzplest.www.model.UserModel;
import sv.com.cruzplest.www.entities.UsersEntity;

/**
 *
 * @author RRDESC04
 */
@ManagedBean
@ViewScoped
public class UsersBean {

    private UserModel model = new UserModel();
    private UsersEntity users;

    /**
     * Creates a new instance of UsersBean
     */
    public UsersBean() {
        users = new UsersEntity();
    }

    public List<UsersEntity> listarAll() {
        return model.listarAll();
    }

}
