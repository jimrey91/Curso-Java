<%-- 
    Document   : form_mostrar_contribuyentes
    Created on : 09-02-2013, 08:41:35 PM
    Author     : Daniel
--%>

<%@page import="sv.curso.intermedio.practica07.persistencia.Contribuyentes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Contribuyente</title>
        <jsp:useBean id="beanContribuyentes" scope="request" class="sv.curso.intermedio.practica07.mantenimiento.MantenimientoContribuyentesJpa" />
    </head>
    <body>
        <h1>Mostrar Contribuyente</h1>
        
        <% 
            String noNit = request.getParameter("no_nit");
            Contribuyentes contribuyente = beanContribuyentes.consultarContribuyente(noNit);
            
            if (contribuyente ==null) {
                    out.println("No se encontro informacion del Contribuyente...");
                }
            
        %>
        
        <% if (contribuyente !=null){%>
        <form name="Form1" action="procesa_modificacion_contribuyentes.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nit Contribuyente</td>
                        <td><input type="text" name="no_nit" size="15" value="<%= contribuyente.getNoNit() %>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre Contribuyente</td>
                        <td><input type="text" name="nombre_contribuyente" size="65" value="<%= contribuyente.getNombreContribuyente() %>" /></td>
                    </tr>
                    <tr>
                        <td>Razon Social</td>
                        <td><input type="text" name="razon_social" value="<%= contribuyente.getRazonSocial() %>" size="200"  /></td>
                    </tr>
                    <tr>
                        <td>Representante Legal</td>
                        <td><input type="text" name="representante_legal" value="<%= contribuyente.getRepresentanteLegal()%>" size="65"  /></td>
                    </tr>
                    <tr>
                        <td>Renta Anual</td>
                        <td><input type="text" name="renta_anual" value="<%= contribuyente.getRentaAnual() %>" size="10"  /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <center>
                            <input type="submit" value="Guardar" name="Guardar" />
                            <input type="reset" value="Limpiar" name="Limpiar" />
                            </center>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>   
            <% } %>
    </body>
</html>
