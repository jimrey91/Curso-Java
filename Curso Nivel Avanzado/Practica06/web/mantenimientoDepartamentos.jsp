<%-- 
    Document   : mantenimientoDepartamentos
    Created on : 10-29-2013, 03:17:08 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page 
    import= "java.util.*;
    import javax.persistence.*;
    import sv.curso.avanzado.practica06.persistencia.Departamentos;"
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Departamentos</title>
        <jsp:useBean id="mantenimientoDepartamentos" scope="request" 
                     class="sv.curso.avanzado.practica06.mantenimiento.MantenimientoDepartamentoJpa" />
        <script type="text/javascript">
            function validarGuardar()
            {
                var codigoDepartamento=document.forms["Form"]["codigo_departamento"].value;
                var nombreDepartamento=document.forms["Form"]["nombre_departamento"].value;
                if(codigoDepartamento==null || codigoDepartamento=="" )
                    {
                        alert('El codigo del departamento es requerido...');
                        return false;
                    }
                    if(codigoDepartamento.length<2){
                        alert('El codigo del departamento deben ser 2 digitos... ');
                        return false;
                    }
                    if (nombreDepartamento.length<5) {
                        alert('El nombre del departamento deben ser mas de 5 letras... ');
                        return false;
                    }
                    var departamento = document.forms["Form"]["nombre_departamento"].value;
                    if (departamento==null || departamento=="") {
                        alert('El nombre del departamento es obligatorio');
                        return false;
                    }
                    return esNumero(document.forms["Form"]["codigo_departamento"], 'Codigo Departamento No Valido');
            }
            
            function validarConsulta(){
                var codigoDepartamento=document.forms["Form"]["codigo_departamento"].value;
                    if(codigoDepartamento==null || codigoDepartamento=="" )
                    {
                        alert('El codigo del departamento es requerido...');
                        return false;
                    }
                    if(codigoDepartamento.length<2){
                        alert('El codigo del departamento deben ser 2 digitos... ');
                        return false;
                    }
                    return esNumero(document.forms["Form"]["codigo_departamento"], 'Codigo Departamento No Valido');
            }
            
            function esNumero(elemento, mensaje){
                var expresionNumerica = /^[0-9]+$/;
                if (elemento.value.match(expresionNumerica)) {
                    return true;
                }else {
                    alert(mensaje);
                    elemento.focus();
                    return false;
                }

            }
        </script>
    </head>
    <body>
        <h1>Mantenimiento Departamentos</h1>
        <form name="Form" action="mantenimientoDepartamentos.jsp" method="POST">
        <% 
            
        String operacion = request.getParameter("operacion");
        String codigoDepartamento = request.getParameter("codigo_departamento");
        String nombreDepartamento = request.getParameter("nombre_departamento");  
                
        if(operacion!=null){
            if(operacion.equals("Guardar")){
                Departamentos depto = mantenimientoDepartamentos.consultarDepartamentos(codigoDepartamento);
                if(depto==null){
                    Departamentos departamentos = new Departamentos();
                    departamentos.setCodigoDepartamento(codigoDepartamento);
                    departamentos.setDepartamento(nombreDepartamento);
                    java.util.Date hoy = new java.util.Date();
                    departamentos.setFechaCreacion(hoy);
                    int flag = mantenimientoDepartamentos.guardarDepartamento(departamentos);
                    if(flag==1){
                        out.println("<h2>Departamento Guardado Satisfactoriamente</h2>");
                    }else{
                        out.println("<h2>Departamento No Pudo ser Guardado</h2>");
                    }
                }else{
                    out.println("<h2>Departamento Ya esta Registrado</h2>");
                }
              }
            
            if(operacion.equals("Eliminar")){
                int flag = mantenimientoDepartamentos.eliminarDepartamento(codigoDepartamento);
                if(flag==1){
                    out.println("<h2>Departamento Eliminado Satisfactoriamente</h2>");
                }else{
                    out.println("<h2>Departamento No Pudo ser Eliminado</h2>");
                }
            }
            
            if(operacion.equals("Consultar")){
                Departamentos depto = mantenimientoDepartamentos.consultarDepartamentos(codigoDepartamento);
                
                if(depto==null){
                    out.println("<h2>Departamento No Existe</h2>");
                }else{
                    nombreDepartamento = depto.getDepartamento();
                    codigoDepartamento = depto.getCodigoDepartamento();
                }
            }
            
            if(operacion.equals("Modificar")){
                Departamentos depto = mantenimientoDepartamentos.consultarDepartamentos(codigoDepartamento);
                if(depto!=null){
                    Departamentos departamentos = new Departamentos();
                    departamentos.setCodigoDepartamento(codigoDepartamento);
                    departamentos.setDepartamento(nombreDepartamento);
                    java.util.Date hoy = new java.util.Date();
                    departamentos.setFechaCreacion(hoy);
                    int flag = mantenimientoDepartamentos.modificarDepartamentos(departamentos);
                    if(flag==1){
                        out.println("<h2>Departamento Modificado Satisfactoriamente</h2>");
                    }else{
                        out.println("<h2>Departamento No Pudo ser Modificado</h2>");
                    }
                  }else{
                    out.println("<h2>Departamento No esta Registrado</h2>");
                }
               }
            
            if(operacion.equals("Limpiar")){
                codigoDepartamento = "";
                nombreDepartamento = "";
            }
            
            if(operacion.equals("Consultar Todos")){
            %>    
            <table border="1" bgcolor="#CEECF5">
                <tbody>
                    <tr>
                        <td>Departamento</td>
                        <td>Nombre</td>
                    </tr>
                    
                <%
                List<Departamentos>listadepartamentos = 
                        mantenimientoDepartamentos.consultarTodosDepartamentos();
                Iterator it = listadepartamentos.iterator();
                while (it.hasNext()) {
                        Departamentos d = (Departamentos)it.next();
                %>
                <tr>
                    <td><%=d.getCodigoDepartamento() %></td>
                    <td><%=d.getDepartamento() %></td>
                </tr>
                            
                <%            
                }
                %>
                </tbody>
            </table>
                <br>
            
            <%               
          }     
        }else{
            out.println("<h2>Seleccione una opcion</h2>");
        }
            %>
        <table border="1" bgcolor="#CEECF5">
            <tbody>
                <tr>
                    <td>Codigo Departamento</td>
                    <td><input type="text" name="codigo_departamento" maxlength="2" size="5" value="<%=codigoDepartamento%>"/></td>
                </tr>
                <tr>
                    <td>Nombre Departamento</td>
                    <td><input type="text" name="nombre_departamento" maxlength="25" size="30" 
                               onblur="this.value=this.value.toUpperCase()" value="<%=nombreDepartamento%>"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Guardar" name="operacion" onClick="return validarGuardar()"/>
                        <input type="submit" value="Consultar" name="operacion" onClick="return validarConsulta()"/>
                        <input type="submit" value="Modificar" name="operacion" onClick="return validarGuardar()"/>
                        <input type="submit" value="Eliminar" name="operacion" onClick="return validarConsulta()"/>
                        <br>
                        <input type="submit" value="Consultar Todos" name="operacion" />
                        <input type="submit" value="Limpiar" name="operacion" />
                    </td>
                </tr>
            </tbody>
        </table>
       </form>
    </body>
</html>
