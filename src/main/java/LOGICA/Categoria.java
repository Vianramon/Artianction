
package LOGICA;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id_categoria;
    private String Pintura;
    private String Musica;
    private String Literatura;
    private String Fotografia;
    private String Arte;
    private String Escultura;
   
    @ManyToOne
    @JoinColumn (name = "id_Artistas")
    private Artistas Art;
    
    @ManyToOne
    @JoinColumn (name = "id_Perfil")
    private Perfil perf;
    
    
    @ManyToOne
    @JoinColumn (name = "id_Expertos_arte")
    private Expertos_arte exp;
    
    @ManyToOne
    @JoinColumn (name = "id_Coleccionistas")
    private Coleccionistas col;
    
    
    public Categoria() {
    }

    public Categoria(int id_categoria, String Pintura, String Musica, String Literatura, String Fotografia, String Arte, String Escultura, Perfil Perf, Usuario usu) {
        this.id_categoria = id_categoria;
        this.Pintura = Pintura;
        this.Musica = Musica;
        this.Literatura = Literatura;
        this.Fotografia = Fotografia;
        this.Arte = Arte;
        this.Escultura = Escultura;
        
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getPintura() {
        return Pintura;
    }

    public void setPintura(String Pintura) {
        this.Pintura = Pintura;
    }

    public String getMusica() {
        return Musica;
    }

    public void setMusica(String Musica) {
        this.Musica = Musica;
    }

    public String getLiteratura() {
        return Literatura;
    }

    public void setLiteratura(String Literatura) {
        this.Literatura = Literatura;
    }

    public String getFotografia() {
        return Fotografia;
    }

    public void setFotografia(String Fotografia) {
        this.Fotografia = Fotografia;
    }

    public String getArte() {
        return Arte;
    }

    public void setArte(String Arte) {
        this.Arte = Arte;
    }

    public String getEscultura() {
        return Escultura;
    }

    public void setEscultura(String Escultura) {
        this.Escultura = Escultura;
    }

    

     }