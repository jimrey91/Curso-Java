<%-- 
    Document   : procesa_rentaImponible
    Created on : 09-10-2013, 05:28:31 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Renta Imponible</title>
        <jsp:useBean id="beanRenta" scope="request" class="sv.curso.intermedio.mantenimientorenta.MantenimientoRenta" />
    </head>
    <body>
        <h1>Procesa Renta Imponible</h1>
        <%
            String noNit = request.getParameter("no_nit");
            String nombre = request.getParameter("nombre");
            String salarioAnual = request.getParameter("salario_anual");
            String aguinaldo = request.getParameter("aguinaldo");
            String ingresosServicios = request.getParameter("ingresos_servicios");
            
            out.print("No nit               :" + noNit + "<br/>");
            out.print("Nombre               :" + nombre + "<br/>");
            out.print("Salario Anual        :" + salarioAnual + "<br/>");
            out.print("Aguinaldo            :" + aguinaldo + "<br/>");
            out.print("Ingreso por servicios:" + ingresosServicios + "<br/>");
            
            
            
          double afp = Double.parseDouble(salarioAnual) * (6.25/100);
          double rimp = Double.parseDouble(salarioAnual) - afp;
//        //Tramo I
           if(rimp <= 4064.00){
           out.print("Exento de impuesto");
          //Tramo II
        }else if(rimp <= 9142.86){
            double rimpt = 0.10 * (rimp - 2514.29) + 212.12;
           out.print("La renta imponible es de: " +rimpt+"<br/>");
          //Tramo III
        }else if(rimp <= 22857.14){
            double rimpt = 0.20 * (rimp - 9142.87) + 720.00;
           out.print( "La renta imponible es de: " + rimpt+"<br/>");
          //Tramo IV
        }else if(rimp >= 22857.15){
           double rimpt = 0.30 *(rimp - 22857.15) + 3482.86;
          out.print("La renta imponible es de: " + rimpt+"<br/>");
        }
            
            %>
    </body>
</html>
