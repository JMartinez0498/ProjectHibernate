package sv.edu.udb.www.entities;
// Generated 02-nov-2017 18:39:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Autores generated by hbm2java
 */
public class Autores  implements java.io.Serializable {


     private String codigoAutor;
     private String nombreAutor;
     private String nacionalidad;
     private Set libroses = new HashSet(0);

    public Autores() {
    }

	
    public Autores(String codigoAutor, String nombreAutor, String nacionalidad) {
        this.codigoAutor = codigoAutor;
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
    }
    public Autores(String codigoAutor, String nombreAutor, String nacionalidad, Set libroses) {
       this.codigoAutor = codigoAutor;
       this.nombreAutor = nombreAutor;
       this.nacionalidad = nacionalidad;
       this.libroses = libroses;
    }
   
    public String getCodigoAutor() {
        return this.codigoAutor;
    }
    
    public void setCodigoAutor(String codigoAutor) {
        this.codigoAutor = codigoAutor;
    }
    public String getNombreAutor() {
        return this.nombreAutor;
    }
    
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Set getLibroses() {
        return this.libroses;
    }
    
    public void setLibroses(Set libroses) {
        this.libroses = libroses;
    }




}


