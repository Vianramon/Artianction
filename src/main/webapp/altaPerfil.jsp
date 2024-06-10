
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "Componentes/header.jsp"%>
<%@include file = "Componentes/body.jsp"%>

<h1>Alta Perfil</h1>
<p>Estas son pruebas plataforma arte</p>

<form class="perfil" action="Svperfil" method="POST">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="  form-control" id="example NombreUsuario "
                                          name="NombreUsuario"  placeholder="Nombre del usuario">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control" id="example Contraseña"
                                           name="password" placeholder="Contraseña">
                                    </div>
                                    
                                    <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control" id="example Rol"
                                           name="Rol" placeholder="Rol">
                                    </div>
                                    
                                    
                                </div>
                                
    
                                <button class = " btn-primary btn-user btn-block" type="submit">
                                   Crear Perfil
                                </button>
                               
                            </form>

<%@include file = "Componentes/bodyf.jsp"%>