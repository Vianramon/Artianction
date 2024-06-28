<%@page import="LOGICA.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "Componentes/header.jsp"%>
<%@include file = "Componentes/body.jsp"%>

<h1>Editar perfil </h1>
<p>Edita la informaciòn de perfil de los expositores de arte </p>

<% Perfil perf = (Perfil)request.getSession().getAttribute("datosPerfil");%>

<form class="perfil" action="Sveditarperfil" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="  form-control" id="example NombreUsuario "
                                          name="NombreUsuario"  placeholder="Nombre del usuario" value="<%=perf.getNombreUsuario()%>">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control" id="example Contraseña"
                                           name="password" placeholder="Contraseña" value="<%=perf.getPassword()%>
                                    </div>
                                    
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control" id="example Rol"
                                           name="Rol" placeholder="Rol" value="<%=perf.getRol()%>
                                    
                                    
                                    
                                </div>
                                
    
                                <button class = " btn-primary btn-user btn-block" type="submit">
                                   Confirmar Cambios 
                                </button>
                               
                            </form>

<%@include file = "Componentes/bodyf.jsp"%>