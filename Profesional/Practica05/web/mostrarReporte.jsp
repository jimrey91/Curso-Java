<%-- 
    Document   : mostrarReporte
    Created on : 12-16-2013, 06:54:30 PM
    Author     : Daniel Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
/* importar biblioteca JasperReports*/
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.engine.util.JRLoader" %>
<%@page import="net.sf.jasperreports.view.JasperViewer"  %>

<%@page import="java.util.*" %>
<%@page import="java.io.*"  %>
<%@page import="java.sql.*"  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Connection conn;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "universidad", "admin");
            
            /*Se establece ruta del reporte*/
            JasperReport reporte = JasperCompileManager.compileReport("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Profesional\\Practica05\\src\\java\\reportes\\ReporteDepartamento");
            byte[] bytes = JasperRunManager.runReportToPdf(reporte, null, conn);
            
            /* Se indica que la respuesta sera en formato PDF*/
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            
            /*Limpiar y cerrar flujo de salida */
            outputStream.flush();
            outputStream.close();
        %>
    </body>
</html>
