/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.mangead_beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.Autores;
import sv.edu.udb.www.entities.Editoriales;
import sv.edu.udb.www.entities.Generos;
import sv.edu.udb.www.entities.Libros;
import sv.edu.udb.www.models.EditorialesModel;

import sv.edu.udb.www.models.LibrosModel;
import sv.edu.udb.www.utils.JsfUtils;


/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class librosBean {
    /**
     * Creates a new instance of editorialesBean
     */
    private LibrosModel em = new LibrosModel();
    private Libros libros;

    private List<Libros> listaLibros;

  

    public List<Libros> getListaLibros() {
        return em.listarLibros();
    }

    public void setListaLibros(List<Libros> listaLibros) {
        this.listaLibros = listaLibros;
    }
    public librosBean() {
        libros= new Libros();
    }

     
    
    public String insertar(){
        if(em.insertarLibros(libros)>0){
            JsfUtils.setFlashMessage("Exito","Libro registrado exitosamente");
        return "listaLibros";
        }else{
            JsfUtils.addErrorMessage(null, "Ya existe un libro con este codigo");
            return null;
        }
        
    }
    public String obtener(){
        String codigo=JsfUtils.getRequest().getParameter("codigo");
        libros=em.obtenerLibros(codigo);
        return "editarLibros";
    }
    public String modificar(){
         if (em.modificarLibros(libros) > 0) {
            JsfUtils.setFlashMessage("exito", "Libro modificado exitosamente");
            return "listaLibros?faces-redirect=true";
        } else {
           JsfUtils.setFlashMessage("fracaso", "No se modificaron los datos del editorial");
            return null;
        }
    }
     public String eliminar() {
        String codigo = JsfUtils.getRequest().getParameter("codigo");
        if (em.eliminarLibro(codigo) > 0) {
            JsfUtils.setFlashMessage("exito", "Libro eliminado exitosamente");
        } else {
            JsfUtils.setFlashMessage("fracaso", "No se pudo eliminar este libro");
        }
        return "listaLibros?faces-redirect=true";
    }

    
    
}
