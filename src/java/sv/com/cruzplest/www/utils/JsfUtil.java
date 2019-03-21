package sv.com.cruzplest.www.utils;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JsfUtil {

    /*Este método permite definir un mensaje de error.
        Recibe como parámetro del id del control asociado al error
       y el propio mensaje de error */
    public static void setErrorMessage(String idClient, String msg) {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(idClient, mensaje);
    }

    /*Este método permite definir un mensaje de tipo flash (mensaje quse elimina de forma automatica en cuanto una vista lo muestre)*/
    public static void setFlashMessage(String name, String msg) {
        FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().put(name, msg);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static Object getManagedBean(String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elc = fc.getELContext();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        ValueExpression ve = ef.createValueExpression(elc, getJsfEl(beanName), Object.class);
        return ve.getValue(elc);
    }

    private static String getJsfEl(String value) {
        return "#{" + value + "}";
    }
}
