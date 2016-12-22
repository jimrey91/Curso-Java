<%-- 
    Document   : procesa_modificacion_contribuyentes
    Created on : 09-02-2013, 09:56:18 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Modificacion de Contribuyentes</title>
        <jsp:useBean id="beanContribuyentes" scope="request" class="sv.curso.intermedio.practica07.mantenimiento.MantenimientoContribuyentesJpa" />
    </head>
    <body>
        <h1>Procesa Modificacion de Contribuyentes</h1>
        <% 
            String noNit = request.getParameter("no_nit");
            String nombreContribuyente = request.getParameter("nombre_contribuyente");
            String razonSocial = request.getParameter("razon_social");
            String representanteLegal = request.getParameter("representante_legal");
            String rentaAnual = request.getParameter("renta_anual");
            
            out.println("No Nit              : " + noNit + "<br>");
            out.println("Nombre Contribuyente: " + nombreContribuyente + "<br>");
            out.println("Razon Social        : " + razonSocial + "<br>");
            out.println("Representante Legal : " + representanteLegal + "<br>");
            out.println("Renta Anual         : " + rentaAnual + "<br>");
            
            if (beanContribuyentes.consultarContribuyente(noNit)==null) {
                    out.print("Contribuyente no se encuentra registrado...");
                }else{
                    if (beanContribuyentes.modificarContribuyente(noNit, nombreContribuyente, razonSocial,
                            representanteLegal, Double.parseDouble(rentaAnual))==1) {
                            out.print("Contribuyente modificado satisfactoriamente...");
                        }
                    }
        %>     
    </body>
</html>
