/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.utils;

/**
 *
 * @author Saplic 01
 */
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.com.cruzplest.www.entities.UsersEntity;
//import sv.com.cruzplest.www.entities.UsersEntity;
import sv.com.cruzplest.www.model.UserModel;

@ManagedBean
@ViewScoped

public class Verificarsesion implements Serializable {

    private String mensaje;
    public int tipo;

    public void verificarsession() throws IOException {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            UsersEntity us = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nivel");
            UsersEntity usuario = new UsersEntity();
            String nombre = null;

            if (us == null) {
                System.out.print("hola que tal");
//            FacesContext.getCurrentInstance().getExternalContext().redirect("../index?faces-redirect=true");
                FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml?error=true");
//            return "/PLEST/inffffdex";
            } else {
//                FacesContext.getCurrentInstance().getExternalContext().redirect("user1/index.xhtml");
            }
        } catch (Exception e) {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?error=true");

            JsfUtil.setErrorMessage(null, "Error interno");
//            return "sdf";
        }

    }

    public int dameeltipo() {
        int devolver = 0;
        try {
            UsersEntity us = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            devolver = us.getTipou().getCodigousertype();
        } catch (Exception e) {
        }

        return devolver;

    }

//    public void verificarsession2() throws IOException {
//        try {
//
//            FacesContext context = FacesContext.getCurrentInstance();
//            UsersEntity us = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nivel2");
////        UsuariosEntity usuario = new UsuariosEntity();
//            String nombre = null;
//
//            if (us == null) {
//
//                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?error=true");
//            } else {
//                //System.out.println("Hasta aqui el estado es: " + us.getActivo().toString()+" en el metodo de veriicarusuario2");
////                if (us.getActivo() == false) {
////                    nombre = us.getNombres();
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido Tecnico", nombre));
////                    UsuariosModel model = new UsuariosModel();
////                    UsersEntity cambiaractivo = new UsuariosEntity();
////                    cambiaractivo.setIdusuario(us.getIdusuario());
////                    cambiaractivo.setNombres(us.getNombres());
////                    cambiaractivo.setPass(us.getPass());
////                    cambiaractivo.setTipousuario(us.getTipousuario());
////                    cambiaractivo.setGenero(us.getGenero());
////                    cambiaractivo.setActivo(Boolean.TRUE);
////                    model.modificarUsuarios(cambiaractivo);
////                    us.setActivo(Boolean.TRUE);
////                    this.setMensaje(us.getNombres());
////                }
//
//            }
//
//        } catch (Exception e) {
//
//            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?error=true");
//            JsfUtil.setErrorMessage(null, "Error interno");
//        }
//    }
//    public void verificarsession3() throws IOException {
//        try {
//
//            FacesContext context = FacesContext.getCurrentInstance();
//            UsersEntity us = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nivel3");
////        UsuariosEntity usuario = new UsuariosEntity();
//            String nombre = null;
//
//            if (us == null) {
//
//                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?error=true");
//            } else {
//                //System.out.println("Hasta aqui el estado es: " + us.getActivo().toString()+" en el metodo de veriicarusuario2");
////                if (us.getActivo() == false) {
////                    nombre = us.getNombres();
////                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", nombre));
////                    UsuariosModel model = new UsuariosModel();
////                    UsersEntity cambiaractivo = new UsuariosEntity();
////                    cambiaractivo.setIdusuario(us.getIdusuario());
////                    cambiaractivo.setNombres(us.getNombres());
////                    cambiaractivo.setPass(us.getPass());
////                    cambiaractivo.setTipousuario(us.getTipousuario());
////                    cambiaractivo.setGenero(us.getGenero());
////                    cambiaractivo.setActivo(Boolean.TRUE);
////                    model.modificarUsuarios(cambiaractivo);
////                    us.setActivo(Boolean.TRUE);
////                    this.setMensaje(us.getNombres());
////                }
//
//            }
//
//        } catch (Exception e) {
//
//            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml?error=true");
//            JsfUtil.setErrorMessage(null, "Error interno");
//        }
//    }
    /**
     * @return the mensaje
     */
    public String getMensaje() {
        try {
            UsersEntity us = (UsersEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            return us.getNombre();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error interno ", "Al obtener session"));

        }
        return null;

    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
