/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERSISTENCIA;

import LOGICA.Perfil;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    
   ArtistasJpaController ArtJPA = new ArtistasJpaController();
   CategoriaJpaController CatJPA = new CategoriaJpaController();
   ColeccionistasJpaController ColJPA = new ColeccionistasJpaController();
   Expertos_arteJpaController ExpJPA = new Expertos_arteJpaController(); 
   PerfilJpaController PerfJPA = new PerfilJpaController(); 
   UsuarioJpaController UsuJPA = new UsuarioJpaController();         

    public ControladoraPersistencia() {
    }

    
   
   
   public void crearPerfil(Perfil perf) {
    PerfJPA.create(perf);
           
}

    public List<Perfil> getPerfil() {
    return PerfJPA.findPerfilEntities();
}
    }