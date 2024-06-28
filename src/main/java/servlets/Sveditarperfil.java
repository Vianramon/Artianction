
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



@WebServlet(name = "Sveditarperfil", urlPatterns = {"/Sveditarperfil"})
public class Sveditarperfil extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        }
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id= Integer.parseInt(request.getParameter("id"));
        Perfil perf = control.datosPerfil(id);
        
        HttpSession sessionperfil= request.getSession ();
        sessionperfil.setAttribute("datosPerfil", perf);
        
        System.out.println("El perfil es:"+perf.getNombreUsuario());
        response.sendRedirect("editarPerfil.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    String NombreUsuario = request.getParameter ("NombreUsuario");
    String password= request.getParameter ("password");
    String Rol=request.getParameter ("Rol");
    
   Perfil perf =(Perfil) request.getSession ().getAttribute("datosPerfil");
  
        perf.setNombreUsuario(NombreUsuario);
        perf.setPassword(password);
        perf.setRol(Rol);
        
        control.editarPerfil(perf);
        
        response.sendRedirect("VerexpositoresArte.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
