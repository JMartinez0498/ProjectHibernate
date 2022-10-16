/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.mangead_beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import sv.edu.udb.www.entities.Editoriales;
import sv.edu.udb.www.models.EditorialesModel;
import sv.edu.udb.www.utils.JsfUtils;


/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class editorialesBean {
    /**
     * Creates a new instance of editorialesBean
     */
    private EditorialesModel em = new EditorialesModel();
    private Editoriales editorial ;
    private List<Editoriales> listaEditoriales;
    public editorialesBean() {
        editorial= new Editoriales();
    }

    public Editoriales getEditorial() {
        return editorial;
    }

    public void setEditorial(Editoriales editorial) {
        this.editorial = editorial;
    }

    public List<Editoriales> getListaEditoriales() {
        return em.listarEditoriales();
    }

    public void setListaEditoriales(List<Editoriales> listaEditoriales) {
        this.listaEditoriales = listaEditoriales;
    }
    
    public String insertar(){
        if(em.insertarEditorial(editorial)>0){
            JsfUtils.setFlashMessage("Exito","Editorial registrada exitosamente");
        return "listaEditoriales";
        }else{
            JsfUtils.addErrorMessage(null, "Ya existe un editorial con este codigo");
            return null;
        }
        
    }
    public String obtener(){
        String codigo=JsfUtils.getRequest().getParameter("codigo");
        editorial=em.obtenerEditorial(codigo);
        return "editarEditorial";
    }
    public String modificar(){
         if (em.modificarEditorial(editorial) > 0) {
            JsfUtils.setFlashMessage("exito", "Editorial modificada exitosamente");
            return "listaEditoriales?faces-redirect=true";
        } else {
           JsfUtils.setFlashMessage("fracaso", "No se modificaron los datos del editorial");
            return null;
        }
    }
     public String eliminar() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        if (em.eliminarEditorial(codigo) > 0) {
            JsfUtils.setFlashMessage("exito", "Editorial eliminada exitosamente");
        } else {
            JsfUtils.setFlashMessage("fracaso", "No se pudo eliminar este editorial");
        }
        return "listaEditoriales?faces-redirect=true";
    }

    
    
}
