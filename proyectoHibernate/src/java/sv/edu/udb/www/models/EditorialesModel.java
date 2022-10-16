package sv.edu.udb.www.models;

import java.util.List;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.entities.Editoriales;

public class EditorialesModel {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarEditorial(Editoriales editorial) {
        Session sesion = factory.openSession();
        try {
            Transaction tran = sesion.beginTransaction();
            sesion.save(editorial);
            tran.commit();
            sesion.close();
            return 1;
        } catch (Exception e) {
            sesion.close();
            return 0;
        }
    }

    public int modificarEditorial(Editoriales editorial) {
        Session sesion = factory.openSession();
        try {
            Transaction tran = sesion.beginTransaction();
            sesion.update(editorial);
            tran.commit();
            sesion.close();
            return 1;
        } catch (Exception e) {
            sesion.close();
            return 0;
        }
    }

      public Editoriales obtenerEditorial(String codigo){
        Session sesion=factory.openSession();
        try{
            Editoriales editorial= (Editoriales) sesion.get(Editoriales.class, codigo);
            sesion.close();
            return editorial;
        }catch(Exception e){
            sesion.close();
            return null;
        }
    }
      public int eliminarEditorial(String codigo){
          Session sesion= factory.openSession();
          try{
           
              Editoriales editorial=(Editoriales) sesion.get(Editoriales.class, codigo);
              if(editorial !=null){ 
                  Transaction tran= sesion.beginTransaction();
                  sesion.delete(editorial);
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
      public List<Editoriales> listarEditoriales(){
          Session sesion= factory.openSession();
          try{
              List<Editoriales> lista;
              Query query=sesion.createQuery("SELECT e from Editoriales e");
              lista=query.list();
              sesion.close();
              return lista;
          }catch(Exception e){
              sesion.close();
              return null;
              
          }
      
      }
}
