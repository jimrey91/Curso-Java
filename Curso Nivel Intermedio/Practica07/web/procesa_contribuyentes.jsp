<%-- 
    Document   : procesa_contribuyentes
    Created on : 09-02-2013, 07:14:02 PM
    Author     : Daniel
--%>

<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Adicion de Contribuyentes</title>
        <jsp:useBean id="beanContribuyentes" scope="request" class="sv.curso.intermedio.practica07.mantenimiento.MantenimientoContribuyentesJpa" />
    </head>
    <body>
        <h1>Procesa Adicion de Contribuyentes</h1>
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
            
            sv.curso.intermedio.practica07.persistencia.Contribuyentes contribuyente = new
                    sv.curso.intermedio.practica07.persistencia.Contribuyentes();
            
            contribuyente.setNoNit(noNit);
            contribuyente.setNombreContribuyente(nombreContribuyente);
            contribuyente.setRazonSocial(razonSocial);
            contribuyente.setRepresentanteLegal(representanteLegal);
            contribuyente.setRentaAnual(new BigDecimal(rentaAnual));
        
            if (beanContribuyentes.consultarContribuyente(noNit)==null) {
                if (beanContribuyentes.guardarContribuyente(contribuyente)==1) {
                    out.print("Contribuyente almacenado satisfactoriamente...");
                    }
   
                }else{
                out.print("Contribuyente ya se encuentra registrado...");
            }
        %>
        
        
    </body>
</html>
