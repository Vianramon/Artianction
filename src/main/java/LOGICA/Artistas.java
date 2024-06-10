
package LOGICA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;


@Entity
public class Artistas extends Usuario implements Serializable {
    
    private String Muestra; 
    private String obras ;
    private String Blog;
    private String Contacto;
    private int Calificaciones;
    
   
    
    @OneToMany (mappedBy="Art")
    private List <Categoria>categoria;
         
   
   
    
    

    public Artistas() {
    }

    public Artistas(String Muestra, String obras, String Blog, String Contacto, int Calificaciones, List<Categoria> categoria, int id, String dni, String nombre, String apellido, String telefono, String mail, String ciudad, Date fecha_nacimiento) {
        super(id, dni, nombre, apellido, telefono, mail, ciudad, fecha_nacimiento);
        this.Muestra = Muestra;
        this.obras = obras;
        this.Blog = Blog;
        this.Contacto = Contacto;
        this.Calificaciones = Calificaciones;
        this.categoria = categoria;
    }

    public String getMuestra() {
        return Muestra;
    }

    public void setMuestra(String Muestra) {
        this.Muestra = Muestra;
    }

    public String getObras() {
        return obras;
    }

    public void setObras(String obras) {
        this.obras = obras;
    }

    public String getBlog() {
        return Blog;
    }

    public void setBlog(String Blog) {
        this.Blog = Blog;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public int getCalificaciones() {
        return Calificaciones;
    }

    public void setCalificaciones(int Calificaciones) {
        this.Calificaciones = Calificaciones;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    
}

    
     



