
package LOGICA;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity

public class Perfil extends Usuario implements Serializable{
     
   
   
    private String NombreUsuario;
    private String password;
    private String Rol;
    
   @OneToMany (mappedBy="Perf")
    private List <Categoria>categoria;
    
    

    public Perfil() {
    }

    public Perfil(String NombreUsuario, String password, String Rol, int id, String dni, String nombre, String apellido, String telefono, String mail, String ciudad, Date fecha_nacimiento) {
        super(id, dni, nombre, apellido, telefono, mail, ciudad, fecha_nacimiento);
        this.NombreUsuario = NombreUsuario;
        this.password = password;
        this.Rol = Rol;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    
          
    
  }
      