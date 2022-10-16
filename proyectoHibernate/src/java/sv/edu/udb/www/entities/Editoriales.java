package sv.edu.udb.www.entities;


import java.util.HashSet;
import java.util.Set;

/**
 * Editoriales generated by martinez ayala
 */
public class Editoriales  implements java.io.Serializable {


     private String codigoEditorial;
     private String nombreEditorial;
     private String contacto;
     private String telefono;
     private Set libroses = new HashSet(0);

    public Editoriales() {
    }

	
    public Editoriales(String codigoEditorial, String nombreEditorial, String contacto, String telefono) {
        this.codigoEditorial = codigoEditorial;
        this.nombreEditorial = nombreEditorial;
        this.contacto = contacto;
        this.telefono = telefono;
    }
    public Editoriales(String codigoEditorial, String nombreEditorial, String contacto, String telefono, Set libroses) {
       this.codigoEditorial = codigoEditorial;
       this.nombreEditorial = nombreEditorial;
       this.contacto = contacto;
       this.telefono = telefono;
       this.libroses = libroses;
    }
   
    public String getCodigoEditorial() {
        return this.codigoEditorial;
    }
    
    public void setCodigoEditorial(String codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }
    public String getNombreEditorial() {
        return this.nombreEditorial;
    }
    
    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set getLibroses() {
        return this.libroses;
    }
    
    public void setLibroses(Set libroses) {
        this.libroses = libroses;
    }




}


