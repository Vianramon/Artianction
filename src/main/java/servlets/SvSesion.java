
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

@WebServlet(name = "SvSesion", urlPatterns = {"/SvSesion"})
public class SvSesion extends HttpServlet {

   
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
        
        String NombreUsuario= request.getParameter("NombreUsuario");
        String Password= request.getParameter("Password");
        
        boolean confirmacion=false;
        confirmacion = control.confirmardatos (NombreUsuario,Password);
        
        
        if (confirmacion==true){
              HttpSession datos= request.getSession(true);
              datos.setAttribute("NombreUsuario",NombreUsuario) ;
              response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("datosErrados.jsp");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
