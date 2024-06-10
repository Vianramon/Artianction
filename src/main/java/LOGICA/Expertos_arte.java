
package LOGICA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Expertos_arte extends Usuario implements Serializable  {
    
    
    private String Entrevistas;
    private String Reseñas;
    private String Editoriales;
    private String Blog;
    
    @OneToMany (mappedBy="exp")
    private List <Categoria>categoria;

    public Expertos_arte() {
    }

    public Expertos_arte(String Entrevistas, String Reseñas, String Editoriales, String Blog, List<Categoria> categoria, int id, String dni, String nombre, String apellido, String telefono, String mail, String ciudad, Date fecha_nacimiento) {
        super(id, dni, nombre, apellido, telefono, mail, ciudad, fecha_nacimiento);
        this.Entrevistas = Entrevistas;
        this.Reseñas = Reseñas;
        this.Editoriales = Editoriales;
        this.Blog = Blog;
        this.categoria = categoria;
    }

    public String getEntrevistas() {
        return Entrevistas;
    }

    public void setEntrevistas(String Entrevistas) {
        this.Entrevistas = Entrevistas;
    }

    public String getReseñas() {
        return Reseñas;
    }

    public void setReseñas(String Reseñas) {
        this.Reseñas = Reseñas;
    }

    public String getEditoriales() {
        return Editoriales;
    }

    public void setEditoriales(String Editoriales) {
        this.Editoriales = Editoriales;
    }

    public String getBlog() {
        return Blog;
    }

    public void setBlog(String Blog) {
        this.Blog = Blog;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

   
      }






