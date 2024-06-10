
package LOGICA;


import PERSISTENCIA.ControladoraPersistencia;





public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearPerfil (String nombreUsuario, String password, String rol){
        Perfil perf = new Perfil ();
      
        perf.setNombreUsuario(nombreUsuario);
        perf.setPassword(password);
        perf.setRol(rol);
        
        controlPersis.crearPerfil(perf);
      }  
    }

