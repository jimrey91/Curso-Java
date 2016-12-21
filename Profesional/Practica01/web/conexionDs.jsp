<%-- 
    Document   : conexionDs
    Created on : 12-01-2013, 07:38:46 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,javax.sql.DataSource, javax.naming.*, javax.naming.InitialContext"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Prueba Connection Pool</title>
    </head>
    <body>
        <h1>Prueba de Connection Pool</h1>
        <% 
            DataSource ds = null;
            Connection conn = null;
            try {
                    Context ctx = new InitialContext();
                    ds = (DataSource) ctx.lookup("jdbc/portalDS");
                    conn = ds.getConnection();
                    out.println("Conexion OK  a la Base de Datos");
                } catch (Exception e) {
                    out.println("Error en establecer Conexion a la Base de Datos");
                    e.printStackTrace();
                }
        %>
    </body>
</html>
