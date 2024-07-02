
<%@page import="LOGICA.Perfil"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "Componentes/header.jsp"%>
<%@include file = "Componentes/body.jsp"%>

<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800"> Expositores de arte</h1>
                    <p class="mb-4">Lista de expositores registrados</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Expositores</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px">Accion</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                   
                                
                                        <tr>
                                             <th>Id</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    
                                    
                                    
                                    <% 
                                        List<Perfil>listaPerfil=(List)request.getSession().getAttribute ("listaPerfil");
                                        
                                        %>
                                        
                                    <tbody>
                                        
                                        <% for (Perfil perf:listaPerfil){%>
                                            
                                            
                                        
                                        <tr>
                                      <td id="id_perf <%=perf.getId()%>"> <%=perf.getId()%></td>
                                            <td><%=perf.getNombreUsuario() %></td>
                                            <td><%=perf.getRol()%></td>
                                            
                                            
                                          
                                           <td style ="display: flex; width:230px; ">
                                               <form name ="eliminar" action="Sveliminarperfil" method="POST">
                                             <button  type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red;margin-right: 5px;">
                                                 <i class ="fas fa-trash-alt"> </i> Eliminar
                                             </button>
                                                  
                                                   <input type ="hidden" name="id" value="<%=perf.getId()%>">
                                                    
                                                  
                                               </form>
                                                    
                                                  <form name ="editar" action="Sveditarperfil" method="GET">
                                             <button  type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                                                 <i class ="fas fa-pencil-alt"> </i> Editar
                                             </button>
                                                  
                                                   <input type ="hidden" name="id" value="<%=perf.getId()%>">
                                                    
                                                  
                                               </form>  
                                           </td>
                                         <% } %>
                                        
            
   
  