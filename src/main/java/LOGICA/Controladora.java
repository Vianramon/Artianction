
package LOGICA;


import PERSISTENCIA.ControladoraPersistencia;

import java.util.List;





public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearPerfil (String nombreUsuario, String password, String rol){
        Perfil perf = new Perfil ();
      
        perf.setNombreUsuario(nombreUsuario);
        perf.setPassword(password);
        perf.setRol(rol);
        
        controlPersis.crearPerfil(perf);
      }  

    public List<Perfil> getPerfil() {
       
    return controlPersis.getPerfil();
    
        } 

    public void borrarPerfil(int id) {
    controlPersis.borrarPerfil(id);
    }

 
    public Perfil datosPerfil(int id) {
        return controlPersis.datosPerfil (id);
    }

    public void editarPerfil(Perfil perf) {
    controlPersis.editarPerfil (perf);    

    }
   
        
    
     }
 