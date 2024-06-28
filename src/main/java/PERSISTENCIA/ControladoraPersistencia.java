
package PERSISTENCIA;

import LOGICA.Perfil;
import PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia{
    
   ArtistasJpaController ArtJPA = new ArtistasJpaController();
   CategoriaJpaController CatJPA = new CategoriaJpaController();
   ColeccionistasJpaController ColJPA = new ColeccionistasJpaController();
   Expertos_arteJpaController ExpJPA = new Expertos_arteJpaController(); 
   PerfilJpaController PerfJPA = new PerfilJpaController(); 
   UsuarioJpaController UsuJPA = new UsuarioJpaController();         

   
    
   
   
   public void crearPerfil(Perfil perf) {
    PerfJPA.create(perf);
           
}

    public List<Perfil> getPerfil() {
    return PerfJPA.findPerfilEntities();
}

    

    public void borrarPerfil (int id) {
       try {
           PerfJPA .destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       
    }
     

    }

    public Perfil datosPerfil(int id) {
     return PerfJPA.findPerfil(id);
    }

    public void editarPerfil(Perfil perf) {
       try {   
           PerfJPA.edit (perf);
       } catch (Exception ex) {
           Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        }