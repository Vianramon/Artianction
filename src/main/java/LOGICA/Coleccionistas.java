
package LOGICA;


import java.io.Serializable;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
public class Coleccionistas extends Usuario implements Serializable {
    
    private String tipo_arte;
    private String perfil;
    private String Contacto;
    private int Calificacion;

    
    @OneToMany (mappedBy="col")
    private List <Categoria>categoria;
    
    public Coleccionistas() {
    }

    public Coleccionistas(String tipo_arte, String perfil, String Contacto, int Calificacion, List<Categoria> categoria, int id, String dni, String nombre, String apellido, String telefono, String mail, String ciudad, Date fecha_nacimiento) {
        super(id, dni, nombre, apellido, telefono, mail, ciudad, fecha_nacimiento);
        this.tipo_arte = tipo_arte;
        this.perfil = perfil;
        this.Contacto = Contacto;
        this.Calificacion = Calificacion;
        this.categoria = categoria;
    }

    public String getTipo_arte() {
        return tipo_arte;
    }

    public void setTipo_arte(String tipo_arte) {
        this.tipo_arte = tipo_arte;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

   
    
    }

