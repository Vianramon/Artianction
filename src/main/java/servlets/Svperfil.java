
package servlets;

import LOGICA.Controladora;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name = "Svperfil", urlPatterns = {"/Svperfil"})
public class Svperfil extends HttpServlet {

    Controladora control = new Controladora();
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
