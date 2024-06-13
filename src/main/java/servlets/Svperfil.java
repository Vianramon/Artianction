
package servlets;

import LOGICA.Controladora;
import LOGICA.Perfil;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;




@WebServlet(name = "Svperfil", urlPatterns = {"/Svperfil"})
public class Svperfil extends HttpServlet {

    Controladora control = new Controladora();
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        List<Perfil> listaPerfil= new ArrayList<Perfil>();
        listaPerfil=control.getPerf ();
        
        HttpSession misession=  request.getSession ();
        misession.setAttribute ( "listaPerfil", listaPerfil);
        
        System.out.println("Perfil" + listaPerfil.get (0));
        response.sendRedirect("verArtistas.jsp");
    }

    
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
   
       

    String NombreUsuario = request.getParameter ("NombreUsuario");
    String password= request.getParameter ("password");
    String Rol=request.getParameter ("Rol");
    
        
        
    
    System.out.println ("NombreUsuario es: " + NombreUsuario);
    System.out.println ("password es: " +password);
    System.out.println ("Rol es: " +Rol);
    
    control.crearPerfil (NombreUsuario, password,Rol);
    response.sendRedirect("index.jsp");
            
     }
            
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static class control {

        public control() {
        }
    }

  

}
