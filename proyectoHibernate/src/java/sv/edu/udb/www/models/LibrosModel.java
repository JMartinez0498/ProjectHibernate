/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.models;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.entities.Editoriales;
import sv.edu.udb.www.entities.Libros;

/**
 *
 * @author Jeffrey
 */
public class LibrosModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();

   public List<Libros> listarLibros(){
          Session sesion= factory.openSession();
          try{
              List<Libros> lista;
              Query query=sesion.createQuery("SELECT l from Libros l");
              lista=query.list();
              sesion.close();
              return lista;
          }catch(Exception e){
              sesion.close();
              return null;
              
          }
      
      }

     public int insertarLibros(Libros libros) {
        Session sesion = factory.openSession();
        try {
            Transaction tran = sesion.beginTransaction();
            sesion.save(libros);
            tran.commit();
            sesion.close();
            return 1;
        } catch (Exception e) {
            sesion.close();
            return 0;
        }
    }

    public int modificarLibros(Libros libros) {
        Session sesion = factory.openSession();
        try {
            Transaction tran = sesion.beginTransaction();
            sesion.update(libros);
            tran.commit();
            sesion.close();
            return 1;
        } catch (Exception e) {
            sesion.close();
            return 0;
        }
    }

      public Libros obtenerLibros(String codigo){
        Session sesion=factory.openSession();
        try{
            Libros libros= (Libros) sesion.get(Libros.class, codigo);
            sesion.close();
            return libros;
        }catch(Exception e){
            sesion.close();
            return null;
        }
    }
      public int eliminarLibro(String codigo){
          Session sesion= factory.openSession();
          try{
           
              Libros libros=(Libros) sesion.get(Libros.class, codigo);
              if(libros !=null){ 
                  Transaction tran= sesion.beginTransaction();
                  sesion.delete(libros);
                  tran.commit();
                  sesion.close();
                return 1;
              }
              sesion.close();
              return 0;
          }catch(Exception e){
             sesion.close();
             return 0;
              
          }
      }
     
}
