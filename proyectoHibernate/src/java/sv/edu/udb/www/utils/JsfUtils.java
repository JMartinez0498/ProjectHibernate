package sv.edu.udb.www.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JsfUtils {

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static void addErrorMessage(String clientId, String message) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                message, null);
        contexto.addMessage(clientId, mensaje);

    }

    public static void setFlashMessage(String name, String value) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name, value);
    }

}
