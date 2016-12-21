/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.avanzado.actionforms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Daniel
 */
public class ActionFormDepartamentos extends org.apache.struts.action.ActionForm {
    
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String error;
    private String action;

    /**
     * @return
     */
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    /**
     *
     */
    public ActionFormDepartamentos() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        return errors;
            // TODO: add 'error.name.required' key to your resources
        
    }
}
